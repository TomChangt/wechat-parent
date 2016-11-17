package com.ecdatainfo.wechat.base.utils;

import com.ecdatainfo.wechat.base.constant.Constant;
import com.ecdatainfo.wechat.base.exception.ApiException;
import com.ecdatainfo.wechat.base.response.BaseResponse;
import com.ecdatainfo.wechat.base.response.ResourceError;
import com.ecdatainfo.wechat.model.enums.ErrorCodeEnum;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


/**
 * @author tomchangt
 * @ClassName: ResponseBuilder
 * @Description:  REST Ful请求响应构建工具类
 * @date 2015年10月18日
 */
public class ResponseBuilder {

    /**
     * 构建默认的成功响应信息
     * @return
     */
    public static BaseResponse buildSuccessResponse() {
        BaseResponse response = new BaseResponse();

        response.setSuccess(true);

        response.setMessage(Constant.OPERATE_SUCCESS);

        return response;

    }

    /**
     * 构建默认的成功响应信息
     * @param obj
     * @return
     */
    @SuppressWarnings("unchecked")
    public static BaseResponse buildSuccessResponse(Object obj) {
        if(obj instanceof Page){
    		return buildPager((Page)obj);
    	}
        BaseResponse response = new BaseResponse();

        response.setSuccess(true);
        response.setMessage(Constant.OPERATE_SUCCESS);
        response.setResult(obj);

        return response;

    }

    /**
     * 构建默认的成功响应信息
     * @param list
     * @return
     */
    public static BaseResponse buildSuccessResponseByList(List list) {
        BaseResponse response = new BaseResponse();

        response.setSuccess(true);
        response.setMessage(Constant.OPERATE_SUCCESS);
        response.setResult(list);
        return response;

    }

    /**
     * 构建成功响应信息
     *
     * @param obj
     * @param meessage
     * @return
     */
    public static BaseResponse buildSuccessResponse(Object obj, String meessage) {
    	if(obj instanceof Page){
    		return buildPager((Page) obj);
    	}
        BaseResponse response = new BaseResponse();

        response.setSuccess(true);

        response.setResult(obj);

        response.setMessage(meessage);

        return response;
    }

    /**
     * 构建成功响应信息
     *
     * @param code
     * @param meessage
     * @return
     */
    public static BaseResponse buildFaildResponse(int code, String meessage) {
        ResourceError error = new ResourceError();

        BaseResponse response = new BaseResponse();

        response.setSuccess(false);

        response.setMessage(meessage);

        error.setCode(code);
        error.setMessage(meessage);

        response.setError(error);

        return response;

    }

    /**
     * 构建失败响应信息
     *
     * @param e
     * @return
     */
    public static BaseResponse buildFaildResponse(ApiException e) {
        return buildFaildResponse(e.getCode(), e.getMessage());
    }

    /**
     * 构建错误的响应
     *
     * @param errorCode
     * @return
     */
    public static BaseResponse buildFaildResponse(ErrorCodeEnum errorCode) {
        return buildFaildResponse(errorCode.getCode(), errorCode.getDescription());
    }

    /**
     * 构建分页响应信息
     *
     * @param page
     * @return
     */
    @SuppressWarnings("rawtypes")
    public static BaseResponse buildPager(Page page) {

        PageBean result_info = new PageBean(page);
        BaseResponse response = new BaseResponse();

        response.setSuccess(true);

        response.setResult(result_info);

        return response;
    }
}