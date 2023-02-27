package com.example.ws;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class MyController {


    @GetMapping(value = "/list", name = "获取配置列表")
    public String list() {
        return "abckdef";
    }
}
