package com.neo.controller;

import com.neo.remote.HelloRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

    @Autowired
    HelloRemote helloRemote;
	
    @RequestMapping("/hello/{name}")
//    @HystrixCommand(fallbackMethod = "defaultStores")
    public String index(@PathVariable("name") String name) {
        return helloRemote.hello(name);
    }

    public String defaultStores() {
        return "Ribbon + hystrix ,提供者服务挂了";
    }

}