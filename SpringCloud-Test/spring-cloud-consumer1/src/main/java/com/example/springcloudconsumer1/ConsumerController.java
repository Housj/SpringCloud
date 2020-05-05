package com.example.springcloudconsumer1;

import com.example.springcloudconsumer1.feign.HelloRemote;
import com.sergei.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import javax.annotation.Resource;
import java.util.List;

@RestController
public class ConsumerController {

    @Resource
    HelloRemote helloRemote;
//
//    @Autowired
//    private RestTemplate restTemplate;

    @RequestMapping("/hello/{name}")
    public String demo(@PathVariable("name")String name){
        return helloRemote.hello(name);
    }

    @RequestMapping("/test")
    public String error(){
        return helloRemote.error();
    }


//    @RequestMapping("/")
//    public String findAll(){
////        String string  =  restTemplate.getForEntity("http://localhost:9091/list", String.class).getBody();
//        String string  =  restTemplate.getForObject("http://localhost:9091/list", String.class);
//        return string;
//    }
//
//    @RequestMapping("/2")
//    public List<User> findAll2(){
////        String string  =  restTemplate.getForEntity("http://localhost:9091/list", String.class).getBody();
//        List<User> users  =  restTemplate.getForObject("http://localhost:9091/list2", List.class);
//        User u = new User();
////        restTemplate.postForObject("http://localhost:9091/list2",u,null);
//        return users;
//    }
}
