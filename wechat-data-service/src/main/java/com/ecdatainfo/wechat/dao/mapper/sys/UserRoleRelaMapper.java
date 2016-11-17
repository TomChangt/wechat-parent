package com.ecdatainfo.wechat.dao.mapper.sys;

import com.ecdatainfo.wechat.model.po.sys.UserRoleRela;

public interface UserRoleRelaMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserRoleRela record);

    int insertSelective(UserRoleRela record);

    UserRoleRela selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserRoleRela record);

    int updateByPrimaryKey(UserRoleRela record);
}