package com.wsj.wxnotice.interfaces;

import com.wsj.wxnotice.config.WxConfig;
import com.wsj.wxnotice.vo.Key;
import com.wsj.wxnotice.vo.TextTemplate;
import com.wsj.wxnotice.vo.WxAccessToken;
import com.wsj.wxnotice.vo.WxUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Service
public class WxServiceApi {

    @Autowired
    private WxConfig wxConfig;
    @Autowired
    private RestTemplate restTemplate;
    @Resource
    private RedisTemplate redisTemplate;

    public void updateUser(){
        //全量更新
        String url = "https://qyapi.weixin.qq.com/cgi-bin/user/simplelist?access_token="+getAccessToken()+"&department_id=1";
        WxUser wxUser = restTemplate.getForObject(url, WxUser.class);
        if (wxUser.getErrcode() == 0) {
            List<WxUser.User> userlist = wxUser.getUserlist();
            redisTemplate.opsForValue().set(Key.ALL_USER, userlist);
        }else {
            throw new RuntimeException(wxUser.getErrmsg());
        }
    }

    //获取微信accessToken
    public String getAccessToken(){
        Object accessToken = redisTemplate.opsForValue().get(Key.ACCESS_TOKEN);
        if (null == accessToken) {
            String url = "https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid="+wxConfig.getCorpid()+"&corpsecret="+wxConfig.getCorpsecret();
            WxAccessToken result = restTemplate.getForObject(url, WxAccessToken.class);
            if (result.getErrcode() == 0) {
                redisTemplate.opsForValue().set(Key.ACCESS_TOKEN, result.getAccess_token(), result.getExpires_in(), TimeUnit.SECONDS);
                accessToken = result.getAccess_token();
            }else {
                throw new RuntimeException(result.getErrmsg());
            }
        }
        return accessToken.toString();
    }

    /**
     *
     * @param touser 接受消息的人多人用 | 分隔
     * @param title  消息的标题
     * @param name   事件名称
     * @param tip    温馨提示
     */
    public void sendTextMsgById(String touser, String title,String name,String tip) {
        TextTemplate textTemplate = new TextTemplate(touser,title,name,tip);
        String url = "https://qyapi.weixin.qq.com/cgi-bin/message/send?access_token="+getAccessToken();
        restTemplate.postForObject(url, textTemplate, Map.class);
    }
    public void sendTextMsgByName(String userName, String title,String name,String tip) {
        String id = findOneUser(userName);
        sendTextMsgById(id, title, name, tip);
    }

    /**
     * 返回userId,多个userId用 | 分隔
     * @return
     */
    public String findOneUser(String name){
        List<WxUser.User> accessToken = (List<WxUser.User>) redisTemplate.opsForValue().get(Key.ALL_USER);
        if (null != name && name.length() > 0) {
            WxUser.User user = accessToken.stream().filter(x->x.getName().equals(name)).findFirst().orElse(null);
            if(user==null) throw new RuntimeException("没有找到 "+name);
            return user.getUserid();
        }else{
            return accessToken.stream().map(x -> x.getUserid()).collect(Collectors.joining("|"));
        }
    }
    /**
     * 返回userId,多个userId用 | 分隔
     * @return
     */
    public String findAllUser(){
        return findOneUser(null);
    }

}
