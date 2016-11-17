package com.ecdatainfo.wechat.api.web;

import com.ecdatainfo.wechat.base.exception.ApiException;
import com.ecdatainfo.wechat.base.response.BaseResponse;
import com.ecdatainfo.wechat.base.utils.ResponseBuilder;
import com.ecdatainfo.wechat.model.enums.ErrorCodeEnum;
import com.ecdatainfo.wechat.model.po.sys.User;
import com.ecdatainfo.wechat.model.vo.sys.LoginInfoVO;
import com.ecdatainfo.wechat.security.service.AuthcService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.io.IOException;

/**
 * Created by changtong on 16/9/27.
 */
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private static final Logger logger = LoggerFactory
            .getLogger(AuthController.class);

    @Autowired
    private AuthcService authcService;

    @ApiIgnore
    @RequestMapping(value = "/invalidUser",method = RequestMethod.GET)
    public @ResponseBody BaseResponse invalidUser(){
        return ResponseBuilder.buildFaildResponse(new ApiException(ErrorCodeEnum.AuthFaild));
    }
    @ApiIgnore
    @RequestMapping(value = "/unauthor",method = RequestMethod.GET)
    public @ResponseBody BaseResponse unauthor(){
        return ResponseBuilder.buildFaildResponse(new ApiException(ErrorCodeEnum.NoPermission));
    }


    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ApiOperation(value = "用户登录", response = User.class, httpMethod = "POST", notes = "用户登录")
    @ApiResponses(value = {@ApiResponse(code = 200,response=User.class, message = "OK")})
    public @ResponseBody BaseResponse login(@RequestBody LoginInfoVO loginInfo) throws IOException {
        logger.debug("用户登录，请求参数为：userName={}", loginInfo.getUserPhone());

        UsernamePasswordToken upt = new UsernamePasswordToken(loginInfo.getUserPhone(), loginInfo.getPassword());
        Subject subject = SecurityUtils.getSubject();

        try {
            subject.login(upt);
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return ResponseBuilder.buildFaildResponse(new ApiException(ErrorCodeEnum.AuthFaild));
        }
        return ResponseBuilder.buildSuccessResponse(authcService.saveUser(loginInfo.getUserPhone(), loginInfo.getPassword()));

    }

}
