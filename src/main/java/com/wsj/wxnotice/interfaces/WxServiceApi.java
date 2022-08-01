package com.wsj.wxnotice.interfaces;

import com.wsj.wxnotice.config.ApplicationUtil;
import com.wsj.wxnotice.config.WxConfig;
import com.wsj.wxnotice.vo.WxAccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.support.WebApplicationContextUtils;

@Service
public class WxServiceApi {

    @Autowired
    private WxConfig wxConfig;
    @Autowired
    private RestTemplate restTemplate;

    public void updateUser(){

    }

    //获取微信accessToken
    public String getAccessToken(){
        String url = "https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid="+wxConfig.getCorpid()+"&corpsecret="+wxConfig.getCorpsecret();
        WxAccessToken result = restTemplate.getForObject(url, WxAccessToken.class);
        System.out.println();
        return null;
    }

}
