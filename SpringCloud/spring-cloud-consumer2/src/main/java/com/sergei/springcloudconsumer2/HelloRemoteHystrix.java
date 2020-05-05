package com.sergei.springcloudconsumer2;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

@Component
public class HelloRemoteHystrix implements HelloRemote {
    @Override
    public String hello2(@RequestParam(value = "name") String name) {
        return "hello"+name+",this message send failed! Hystrix!";
    }
}
