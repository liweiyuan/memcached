package com.tingyun;

import com.whalin.MemCached.MemCachedClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by tingyun on 2017/6/26.
 */
public class TestSpring {

    public static void main(String[] args) {
        String path = "application-memcached.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(path);
        //SockIOPool pool = context.getBean("memcachedPool",SockIOPool.class);
        MemCachedClient cache = context.getBean("memCachedClient",MemCachedClient.class);
        cache.add("test", "ppt1");
        System.out.println(cache.get("test"));
    }
}
