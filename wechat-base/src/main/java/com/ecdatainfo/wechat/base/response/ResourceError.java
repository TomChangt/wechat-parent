package com.ecdatainfo.wechat.base.response;

/**
 * 
* @ClassName: ResourceError 
* @Description: 错误信息
* @author tomchangt
* @date 2016年10月18日
*
 */
public class ResourceError {
    private int code;
    private String message;

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
 
}