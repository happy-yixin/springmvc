package com.bailiban.Day01;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {

    @RequestMapping({"/","","get"})
    public String get(){
        return "User";
    }
}
