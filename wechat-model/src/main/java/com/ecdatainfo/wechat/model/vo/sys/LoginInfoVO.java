package com.ecdatainfo.wechat.model.vo.sys;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value = "用户登陆对象", description = "用户登陆对象")
public class LoginInfoVO {


    @ApiModelProperty("密码")
    private String password;


    @ApiModelProperty("用户电话")
    private String userPhone;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }
}