package com.ecdatainfo.wechat.security.config;

import com.ecdatainfo.wechat.base.utils.TokenUtils;
import com.ecdatainfo.wechat.model.enums.ErrorCodeEnum;
import com.ecdatainfo.wechat.model.enums.HttpMethodEnum;
import com.ecdatainfo.wechat.model.po.sys.User;
import com.ecdatainfo.wechat.model.vo.sys.UserInfoVO;
import com.ecdatainfo.wechat.security.service.AuthcService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by changtong on 2016/11/15.
 */
@Component
public class StatelessAuthcFilter extends AccessControlFilter {

    private static final Logger logger = LoggerFactory
            .getLogger(StatelessAuthcFilter.class);

    @Autowired
    private AuthcService authcService;


    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object o) throws Exception {
        return false;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        HttpServletRequest httpRequest = this.getAsHttpRequest(servletRequest);
        String authToken = TokenUtils.extractAuthTokenFromRequest(httpRequest);
        try {
            if (!HttpMethodEnum.OPTIONS.name().equalsIgnoreCase(httpRequest.getMethod())) {
                if ((!StringUtils.isEmpty(authToken) && !"null".equals(authToken))) {
                    UserInfoVO user = authcService.getUserByToken(authToken);

                    if(user != null){
                        UsernamePasswordToken upt = new UsernamePasswordToken(user.getUserPhone(), user.getPassword());
                        try{
                            getSubject(servletRequest, servletResponse).login(upt);
                        }catch (Exception e){
                            logger.error(e.getMessage(), e);
                            this.onLoginFail(servletResponse);
                            return false;
                        }
                    }else{
                        logger.error("Invalid authToken:{}",authToken);
                    }

                }
            }
        }catch (Exception e){
            logger.error(e.getMessage(), e);
        }

        return true;
    }

    //登录失败时默认
    private void onLoginFail(ServletResponse response) throws IOException {
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.setStatus(ErrorCodeEnum.AuthFaild.getCode());
        httpResponse.getWriter().write(ErrorCodeEnum.AuthFaild.getMessage());
    }

    private HttpServletRequest getAsHttpRequest(ServletRequest request) {
        if (!(request instanceof HttpServletRequest)) {
            throw new RuntimeException("Expecting an HTTP request");
        }
        return (HttpServletRequest) request;
    }
}
