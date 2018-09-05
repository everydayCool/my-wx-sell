package com.wx.sell.controller;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Api("管理后台首页")
@Controller("adminIndexController")
@RequestMapping(value = "/admin")
public class IndexController {

    private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);


    @ApiOperation("进入首页")
    @GetMapping(value = {"","/index"})
    public String index(HttpServletRequest request){
        LOGGER.info("Enter admin index method");
        //List<CommentDomain> comments = siteService.getComments(5);
        //List<ContentDomain> contents = siteService.getNewArticles(5);
        //StatisticsDto statistics = siteService.getStatistics();
        // 取最新的20条日志
        //PageInfo<LogDomain> logs = logService.getLogs(1, 5);
        //List<LogDomain> list = logs.getList();
        request.setAttribute("comments", new ArrayList<>());
        request.setAttribute("articles", new ArrayList<>());
        request.setAttribute("statistics", new ArrayList<>());
        request.setAttribute("logs", new ArrayList<>());
        LOGGER.info("Exit admin index method");
        return "admin/index";
    }


}



