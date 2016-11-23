package com.ecdatainfo.wechat.service.sys.impl;

import com.ecdatainfo.wechat.base.utils.ListCopyUtil;
import com.ecdatainfo.wechat.dao.mapper.sys.UserMapper;
import com.ecdatainfo.wechat.model.po.sys.User;
import com.ecdatainfo.wechat.model.vo.sys.UserInfoVO;
import com.ecdatainfo.wechat.service.sys.IUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by changtong on 16/10/15.
 */

@Service
public class UserService implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public PageInfo<UserInfoVO> findAll() {
        PageHelper.startPage(1,5);

        List<User> source =  userMapper.findAll();
        return new PageInfo<UserInfoVO>(ListCopyUtil.copyAsList(source.iterator(),UserInfoVO.class));
    }

    public User findByProp(User user){
        return  userMapper.findByProp(user);
    }
}
