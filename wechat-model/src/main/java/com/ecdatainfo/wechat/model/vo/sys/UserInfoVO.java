package com.ecdatainfo.wechat.model.vo.sys;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value = "用户信息", description = "用户信息")
public class UserInfoVO implements Serializable{

    private static final long serialVersionUID = 1361849913539151384L;

    @ApiModelProperty("OpenID 可以理解微信ID")
    private String openid;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("用户名")
    private String userName;

    @ApiModelProperty("用户电话")
    private String userPhone;

    @ApiModelProperty("用户Email")
    private String userMail;

    @ApiModelProperty("用户认证信息")
    private String token;

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail == null ? null : userMail.trim();
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}