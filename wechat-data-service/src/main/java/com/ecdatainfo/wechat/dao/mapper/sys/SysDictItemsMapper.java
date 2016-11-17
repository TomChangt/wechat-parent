package com.ecdatainfo.wechat.dao.mapper.sys;

import com.ecdatainfo.wechat.model.po.sys.SysDictItems;

public interface SysDictItemsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysDictItems record);

    int insertSelective(SysDictItems record);

    SysDictItems selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysDictItems record);

    int updateByPrimaryKey(SysDictItems record);
}