package com.example.springcloudconsumer1.feign;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

@Component
public class HelloRemoteHystrix implements HelloRemote {
    @Override
    public String hello(@RequestParam(value = "name") String name) {
        return "hello"+name+",this message send failed! Hystrix!";
    }

    @Override
    public String error() {
        return "HelloRemoteHystrix error";
    }
}
