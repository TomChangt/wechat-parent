package com.ecdatainfo.wechat.dao.mapper.sys;

import com.ecdatainfo.wechat.model.po.sys.RoleModuleRela;

public interface RoleModuleRelaMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RoleModuleRela record);

    int insertSelective(RoleModuleRela record);

    RoleModuleRela selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RoleModuleRela record);

    int updateByPrimaryKey(RoleModuleRela record);
}