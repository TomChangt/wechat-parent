package com.ecdatainfo.wechat.dao.mapper.sys;

import com.ecdatainfo.wechat.model.po.sys.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(String openid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String openid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> findAll();

    @Select("select * from t_user where user_phone=#{account}")
    User findByAccount(String account);

    User findByProp(User user);

}