package com.ecdatainfo.wechat.api.web.sys;

import com.ecdatainfo.wechat.api.web.HomeController;
import com.ecdatainfo.wechat.base.response.BaseResponse;
import com.ecdatainfo.wechat.base.utils.PageBean;
import com.ecdatainfo.wechat.base.utils.ResponseBuilder;
import com.ecdatainfo.wechat.model.vo.sys.UserInfoVO;
import com.ecdatainfo.wechat.service.sys.IUserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.HeaderParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by changtong on 16/10/15.
 */
@RestController
@RequestMapping(value = "/api/sys/user")
@Api(value = "用户相关 API", description = "用户相关 API")
public class UserController {


    private static final Logger logger = LoggerFactory
            .getLogger(UserController.class);
    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/userList", method = RequestMethod.GET)
    @ApiOperation(value="获取用户列表",response = UserInfoVO.class,httpMethod = "GET",notes="获取用户列表")
    @ApiResponses(value = { @ApiResponse(code = 200, response = UserInfoVO.class, message = "OK") })
    public @ResponseBody BaseResponse findUserList(@RequestHeader("Authorization") String authorization) {
        logger.debug(".......");
        PageInfo<UserInfoVO> rs = userService.findAll();
        return ResponseBuilder.buildSuccessResponse(rs);

    }


}
