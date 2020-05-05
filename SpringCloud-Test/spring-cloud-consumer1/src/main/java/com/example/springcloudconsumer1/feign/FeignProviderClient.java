package com.example.springcloudconsumer1.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author sergei
 * @create 2020-03-29
 */
//@FeignClient(value = "spring-cloud-producer",fallback = FeignError.class)
public interface FeignProviderClient {

    @GetMapping("/")
    public String index();

    @GetMapping("/error")
    public String list();
}
