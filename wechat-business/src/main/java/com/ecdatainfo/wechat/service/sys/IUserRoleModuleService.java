package com.ecdatainfo.wechat.service.sys;

import com.ecdatainfo.wechat.model.po.sys.Module;
import com.ecdatainfo.wechat.model.po.sys.User;
import com.ecdatainfo.wechat.model.vo.sys.UserInfoVO;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Set;

/**
 * Created by changtong on 16/10/15.
 */

/**
 * 用户角色权限
 */
public interface IUserRoleModuleService {

    public User findByAccount(String account);

    List<Module> findModuleByUserId(String openid);

    Set<String> findPermissions(String account);

    List<String> findPermissionUrl(String account);

}
