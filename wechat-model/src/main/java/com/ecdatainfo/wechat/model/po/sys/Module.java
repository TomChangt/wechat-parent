package com.ecdatainfo.wechat.model.po.sys;

import java.io.Serializable;
import java.util.Date;

public class Module implements Serializable {
    private static final long serialVersionUID = -6708662845321816002L;
    /**路径*/
    public static final int URL_TYPE=1;
    /**功能点*/
    public static final int FUNCTION_TYPE=2;


    private Integer id;

    private String moduleName;

    private String modulePath;

    private Integer moduleType;

    private String moduleKey;

    private Date createTime;

    private Byte recordStatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName == null ? null : moduleName.trim();
    }

    public String getModulePath() {
        return modulePath;
    }

    public void setModulePath(String modulePath) {
        this.modulePath = modulePath == null ? null : modulePath.trim();
    }

    public Integer getModuleType() {
        return moduleType;
    }

    public void setModuleType(Integer moduleType) {
        this.moduleType = moduleType;
    }

    public String getModuleKey() {
        return moduleKey;
    }

    public void setModuleKey(String moduleKey) {
        this.moduleKey = moduleKey == null ? null : moduleKey.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Byte getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(Byte recordStatus) {
        this.recordStatus = recordStatus;
    }
}