package com.ecdatainfo.wechat.base.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 
 * @ClassName: BaseResponse
 * @Description: 基础响应
 * @author zhangtiebin@hn-zhixin.com
 * @date 2015年7月2日 上午10:11:22
 *
 */
@ApiModel(value = "RESTFul基础响应信息", description = "RESTFul基础响应信息")
public class BaseResponse implements Serializable {

    private static final long serialVersionUID = 8909258998770496216L;

    @ApiModelProperty("成功失败标志")
	private Boolean success = true; 
	@ApiModelProperty("错误信息")
	private ResourceError error; 
	@ApiModelProperty("成功提示信息")
	private String message; 
	@ApiModelProperty("响应数据实体")
	private Object result;
	

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public ResourceError getError() {
		return error;
	}

	public void setError(ResourceError error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}
}
