package com.tingyun.controller;


import com.whalin.MemCached.MemCachedClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by tingyun on 2017/6/26.
 */
@RestController
public class HomeController {

    @Autowired
    public  MemCachedClient memCachedClient;


    /*@Bean
    public MemCachedClient getMemCachedClient(@Qualifier("memcachedPool") SockIOPool sockIOPool){
        return new MemCachedClient();
    }
*/

    @RequestMapping("/index")
    public void index(){
        Boolean bool=memCachedClient.add("test222", "ppt1");
        System.out.println(bool);
        String string= (String) memCachedClient.get("test222");
        System.err.println(string);
    }

    @RequestMapping("/hello")
    public String  hello(){

        System.out.print(memCachedClient);
        Boolean bool =memCachedClient.set("java",new Date().toString());
        System.out.println(bool);
        String string= (String) memCachedClient.get("java");
        System.out.println(string);
        return string;
    }

}
