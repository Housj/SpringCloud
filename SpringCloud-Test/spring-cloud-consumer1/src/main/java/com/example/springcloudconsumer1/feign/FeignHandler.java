package com.example.springcloudconsumer1.feign;

import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sergei
 * @create 2020-03-29
 */

@RestController
@RequestMapping("/feign")
public class FeignHandler {
//    @Autowired
//    FeignProviderClient feignProviderClient;

    @Auto
    HelloRemote helloRemote;

    @GetMapping("/hello")
    public String index(String name){
        return  helloRemote.hello(name);
    }

    @GetMapping("/error")
    public String error(){
        return  helloRemote.error();
    }


//    @GetMapping("/index")
//    public String index(){
//        return  feignProviderClient.index();
//    }
//
//    @GetMapping("/list")
//    public String list(){
//        return  feignProviderClient.list();
//    }
}
