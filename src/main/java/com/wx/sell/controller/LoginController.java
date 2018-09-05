package com.wx.sell.controller;


import com.wx.sell.constant.WebConst;
import com.wx.sell.entity.User;
import com.wx.sell.service.UserService;
import com.wx.sell.utils.APIResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Api("登录相关接口")
@Controller
@RequestMapping(value = "/auth")
public class LoginController {

    private static final Logger LOGGER = LogManager.getLogger(LoginController.class);

    @Resource
    private UserService userService;

    /**
     * 跳转到登入页面
     *
     * @return
     */
    @ApiOperation("跳转登录页")
    @GetMapping(value = "/login")
    public String login() {
        return "admin/login";
    }


    /**
     * 管理员登入接口
     *
     * @param request
     * @param response
     * @param username
     * @param password
     * @param remeber_me
     * @return
     */
    @ApiOperation("登录")
    @PostMapping(value = "/login")
    @ResponseBody
    public APIResponse toLogin(HttpServletRequest request,
                               HttpServletResponse response,
                               @ApiParam(name = "username", value = "用户名", required = true)
                               @RequestParam(name = "username", required = true)
                                       String username,
                               @ApiParam(name = "password", value = "密码", required = true)
                               @RequestParam(name = "password", required = true)
                                       String password,
                               @ApiParam(name = "remeber_me", value = "记住我", required = false)
                               @RequestParam(name = "remeber_me", required = false)
                                       String remeber_me) {


        User user = this.userService.login(username, password);

        if (user != null) {

            request.getSession().setAttribute(WebConst.LOGIN_SESSION_KEY, user);

            return APIResponse.success();
        } else {
            return APIResponse.fail("用户名或密码错误");
        }


    }

}





