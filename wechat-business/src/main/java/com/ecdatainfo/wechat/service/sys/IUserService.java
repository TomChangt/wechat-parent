package com.ecdatainfo.wechat.service.sys;


import com.ecdatainfo.wechat.model.po.sys.User;
import com.ecdatainfo.wechat.model.vo.sys.UserInfoVO;
import com.github.pagehelper.PageInfo;

/**
 * Created by changtong on 16/10/15.
 */
public interface IUserService {
     /**
      * 查找所有用户信息(分页)
      * @return
      */
     PageInfo<UserInfoVO> findAll();

     public User findByProp(User user);

}
