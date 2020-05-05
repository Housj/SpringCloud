package com.example.alibabanacosdiscoveryserver;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.stereotype.Service;

/**
 * @author sergei
 * @create 2020-04-01
 */
@Service
public class SentinelResourceService {

    int i = 0;

    @SentinelResource(value = "message",
            blockHandler = "handler",
            fallback = "fall")
    public String message() {
        i++;
        if (i % 2 == 0) {
            throw new RuntimeException();
        }
        return "message";
    }

    public String handler(BlockException e) {
        return "handler";
    }

    public String fall(Throwable e) {
        return "fallback";
    }


}
