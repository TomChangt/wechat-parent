package com.ecdatainfo.wechat.security.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.ecdatainfo.wechat.base.constant.Constant;
import com.ecdatainfo.wechat.base.utils.TokenUtils;
import com.ecdatainfo.wechat.model.po.sys.User;
import com.ecdatainfo.wechat.model.vo.sys.UserInfoVO;
import com.ecdatainfo.wechat.security.config.RedisManager;
import com.ecdatainfo.wechat.security.service.AuthcService;
import com.ecdatainfo.wechat.security.utils.SerializationUtils;
import com.ecdatainfo.wechat.service.sys.impl.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * Created by changtong on 2016/11/15.
 */

@Service
public class AuthcServiceImpl implements AuthcService {

    private static final Logger logger = LoggerFactory
            .getLogger(AuthcServiceImpl.class);


    @Autowired
    private RedisManager redisManager;

    @Autowired
    private UserService userService;


    @Override
    public UserInfoVO getUserByToken(String authToken) {
        UserInfoVO user = null;

        try {
            String key = SerializationUtils.sessionKey(Constant.USER_PERMISSION_CACHE+Constant.DOT, authToken);
            String value = redisManager.get(key);

            if (!StringUtils.isEmpty(value)) {
                redisManager.setex(key,value,Constant.SEC_HALFHOUR);
                user = JSON.parseObject(TokenUtils.decryptBase64(value), UserInfoVO.class);
                return user;
            }
        }catch (Exception e){
            logger.error(e.getMessage());
        }
        return null;
    }


    @Override
    public UserInfoVO saveUser(String userPhone, String password) {
        User user = new User();
        user.setUserPhone(userPhone);
        user.setPassword(TokenUtils.encrytPassword(password));

        User authUser = userService.findByProp(user);

        UserInfoVO vo = new UserInfoVO();

        if(authUser!=null){
            authUser.setPassword(password);
            BeanUtils.copyProperties(authUser,vo);
            String  value = TokenUtils.encrytBase64(JSON.toJSONString(authUser));
            String token = TokenUtils.computeSignature(user);
            String key = SerializationUtils.sessionKey(Constant.USER_PERMISSION_CACHE+Constant.DOT, token);
            redisManager.set(key,value);
            redisManager.setex(key,value,Constant.SEC_HALFHOUR);
            vo.setToken(token);
            vo.setPassword(null);
            return  vo;
        }

        return null;


    }
}
