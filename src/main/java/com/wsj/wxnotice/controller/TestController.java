package com.wsj.wxnotice.controller;

import com.wsj.wxnotice.interfaces.WxServiceApi;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/test")
public class TestController {

    @Resource
    WxServiceApi wxServiceApi;
    @GetMapping
    public String test(){
        wxServiceApi.updateUser();
        return "ok";
    }

}
