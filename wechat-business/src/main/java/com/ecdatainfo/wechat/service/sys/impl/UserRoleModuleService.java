package com.ecdatainfo.wechat.service.sys.impl;

import com.ecdatainfo.wechat.dao.mapper.sys.ModuleMapper;
import com.ecdatainfo.wechat.dao.mapper.sys.UserMapper;
import com.ecdatainfo.wechat.model.po.sys.Module;
import com.ecdatainfo.wechat.model.po.sys.User;
import com.ecdatainfo.wechat.service.sys.IUserRoleModuleService;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * Created by changtong on 16/10/30.
 */
@Service
public class UserRoleModuleService implements IUserRoleModuleService {

    @Autowired
    private ModuleMapper moduleMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<Module> findModuleByUserId(String openid) {
        return moduleMapper.findModuleByUserId(openid);
    }

    @Override
    public Set<String> findPermissions(String account) {
        Set<String> set = Sets.newHashSet();
        User user = findByAccount(account);
        List<Module>modules = moduleMapper.findModuleByUserId(user.getOpenid());

        for(Module info: modules) {
            set.add(info.getModuleKey());
        }
        return set;
    }

    @Override
    public User findByAccount(String account) {
        return userMapper.findByAccount(account);
    }


    @Override
    public List<String> findPermissionUrl(String account) {
        List<String> list = Lists.newArrayList();
        User user = findByAccount(account);
        List<Module>modules = moduleMapper.findModuleByUserId(user.getOpenid());
        for(Module info: modules) {
            if(info.getModuleType() == Module.URL_TYPE) {
                list.add(info.getModulePath());
            }
        }
        return list;
    }
}
