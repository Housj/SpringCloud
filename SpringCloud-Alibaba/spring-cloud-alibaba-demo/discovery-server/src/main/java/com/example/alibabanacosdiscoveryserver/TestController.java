package com.example.alibabanacosdiscoveryserver;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/hello/{str}")
    public String hello(@PathVariable("str") String str){
        System.out.println("invoked name = "+str);
        return "hello 1" + str;
    }

    @GetMapping("/hello2")
    public String hello2(String str){
        System.out.println("invoked name = "+str);
        return "hello 1" + str;
    }
}

