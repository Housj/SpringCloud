package com.example.springcloudconsumer1.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sergei
 * @create 2020-03-29
 */

@Component
public class FeignError implements FeignProviderClient {

    public String index(){
        return  "feign的hystrix";
    }

    @Override
    public String list() {
        return "数据库连接失败";
    }
}
