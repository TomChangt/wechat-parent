package com.ecdatainfo.wechat.model.enums;

/**
 * Created by changtong on 16/10/18.
 */
public enum ErrorCodeEnum {
    // 系统默认异常
    SystemError(10000, "System Error", "系统错误"),
    /****
     * 认证失败
     */
    AuthFaild(10001, "Auth Faild", "认证失败"),

    UnsupportMethod(10002, "Unsupport Method ", "错误的HTTP方法"),
    /**
     * 没有这个API
     */
    NoSuchAPI(10003, "No Such API", "没有这个API"),
    /**
     * 权限不足
     */
    NoPermission(10005, "No Permission", "权限不足"),

    /**
     * Session已经过期
     */
    NOTLOGN(10007, "User not login", "用户未登录"),
    /*****
     * 无效的用户
     */
    InvalidUser(10011, "Invalid User", "无效的用户"),
    /**
     * Session已经过期
     */
    SESSIONISEXPIRED(10006, "Sessiion Is Expired", "Session已经过期"),
    /***
     * 参数错误
     */
    ParamsError(10010, "Params Error", "参数错误");

    private int code;
    private String message;
    private String description;

   private ErrorCodeEnum(int code, String message, String description) {
        this.code = code;
        this.message = message;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
