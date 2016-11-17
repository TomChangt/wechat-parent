package com.ecdatainfo.wechat.model.po.sys;

import java.io.Serializable;

public class UserRoleRela implements Serializable {
    private static final long serialVersionUID = 3100584056884505145L;
    private Integer id;

    private String userId;

    private Integer roleId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}