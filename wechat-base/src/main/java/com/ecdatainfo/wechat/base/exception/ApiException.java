package com.ecdatainfo.wechat.base.exception;

import com.ecdatainfo.wechat.model.enums.ErrorCodeEnum;

import java.io.Serializable;

public class ApiException extends RuntimeException {

	private int code;
	
	public ApiException(){
		
	}
    public ApiException(ErrorCodeEnum error){
    	super(error.getDescription());
    	this.code =  error.getCode();
    }
    public ApiException(ErrorCodeEnum error,String message){
    	super(message);
    	this.code =  error.getCode();
    }
	public int getCode() {
		return code;
	}
    
}