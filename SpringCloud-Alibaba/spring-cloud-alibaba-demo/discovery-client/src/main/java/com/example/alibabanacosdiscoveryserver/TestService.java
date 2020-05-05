package com.example.alibabanacosdiscoveryserver;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author sergei
 * @create 2020-03-31
 */
@FeignClient(value = "spring-cloud-server", fallback = TestServiceFallBack.class)
public interface TestService {

    @GetMapping(value = "/hello/{str}")
    String hello(@PathVariable("str") String str);
}
