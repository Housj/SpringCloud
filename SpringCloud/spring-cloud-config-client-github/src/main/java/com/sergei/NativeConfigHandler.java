package com.sergei;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sergei
 * @create 2020-03-29
 */
@RestController
@RequestMapping("/git")
public class NativeConfigHandler {

    @Value("${neo.hello}")
    private String str;


    @GetMapping("/index")
    public String index(){
        return this.str;
    }

}
