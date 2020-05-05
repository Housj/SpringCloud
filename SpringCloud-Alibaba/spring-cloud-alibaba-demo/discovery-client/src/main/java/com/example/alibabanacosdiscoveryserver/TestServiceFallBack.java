package com.example.alibabanacosdiscoveryserver;

import org.springframework.stereotype.Component;

/**
 * @author sergei
 * @create 2020-04-01
 */

@Component
public class TestServiceFallBack implements TestService {
    @Override
    public String hello(String str) {
        return "TestServiceFallBack.hello()";
    }
}
