package com.sinotest.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sinotest.entity.UserInfo;
import com.sinotest.service.UserInfoService;
import com.sinotest.utils.JedisUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.UUID;

/**
 * @author 86136
 */
@RestController
@RequestMapping("/user")
public class UserContuller {

    @Autowired
    private UserInfoService userInfoService ;
    @Autowired
    private JedisUtil jedisUtil;

    @RequestMapping("/findUser")
    public String  getUser() throws JsonProcessingException {
        String redisKey = "user1";
        boolean f = jedisUtil.exists(redisKey);
        if(f){
            System.out.println("从Rides获取数据");
            String userinfo = jedisUtil.get("user");
            return userinfo ;
        }else{
            System.out.println("从数据库查询数据");
            List<UserInfo> userList = userInfoService.finAllUserInfo();
            ObjectMapper mapper = new ObjectMapper();
            String userStr = mapper.writeValueAsString(userList);
            jedisUtil.set("user",userStr);
            System.out.println(userList.size());
            return userStr;
        }
    }

    @RequestMapping("/save")
    public void sveUser(@RequestBody UserInfo userInfo){
        if(null != userInfo){
            System.out.println("获取入参");
            String id = UUID.randomUUID().toString();
            userInfo.setId(id);
            userInfoService.saveUserInfo(userInfo);
        }
    }



    @Test
    public void setString(){
        Jedis jedis = new Jedis("39.105.192.152",6379);
        jedis.auth("rootpass");

        if(jedis.exists("user")){
            System.out.println(jedis.get("user"));
        }else {
            System.out.println("123213");
        }

    }
}
