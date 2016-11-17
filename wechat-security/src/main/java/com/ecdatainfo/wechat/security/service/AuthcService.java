package com.ecdatainfo.wechat.security.service;

import com.ecdatainfo.wechat.model.po.sys.User;
import com.ecdatainfo.wechat.model.vo.sys.UserInfoVO;

/**
 * Created by changtong on 2016/11/15.
 */

public interface AuthcService {

    /**
     * 通过 authToken 获取用户信息
     *
     * @param authToken
     * @return
     */
    UserInfoVO getUserByToken(String authToken);


    UserInfoVO saveUser(String username,String password);
}
