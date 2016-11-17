package com.ecdatainfo.wechat.dao.mapper.sys;

import com.ecdatainfo.wechat.model.po.sys.Module;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ModuleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Module record);

    int insertSelective(Module record);

    Module selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Module record);

    int updateByPrimaryKey(Module record);


    /**
     * 获取该人的权限模块
     * @param openid
     * @return
     */
    List<Module> findModuleByUserId(String openid);

}