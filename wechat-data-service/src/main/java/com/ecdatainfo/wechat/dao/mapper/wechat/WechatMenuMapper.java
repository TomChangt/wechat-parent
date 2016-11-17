package com.ecdatainfo.wechat.dao.mapper.wechat;

import com.ecdatainfo.wechat.model.po.wechat.WechatMenu;

public interface WechatMenuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WechatMenu record);

    int insertSelective(WechatMenu record);

    WechatMenu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WechatMenu record);

    int updateByPrimaryKey(WechatMenu record);
}