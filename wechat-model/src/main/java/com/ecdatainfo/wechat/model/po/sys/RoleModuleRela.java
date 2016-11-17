package com.ecdatainfo.wechat.model.po.sys;

import java.io.Serializable;

public class RoleModuleRela implements Serializable {
    private static final long serialVersionUID = 3641555454025231822L;
    private Integer id;

    private Integer roleId;

    private Integer moduleId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getModuleId() {
        return moduleId;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }
}