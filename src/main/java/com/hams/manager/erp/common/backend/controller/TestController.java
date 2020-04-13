package com.hams.manager.erp.common.backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 功能说明: <br>
 * 系统版本: v1.0<br>
 * 开发人员: @author lh<br>
 * 开发时间: 2020/4/12<br>
 */
@RequestMapping("test")
@Controller
public class TestController {


    @GetMapping("test")
    public String test(){
        return  "test/test";
    }

}
