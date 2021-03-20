package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

//在templates目录下的所有页面，只能通过controller跳转
@Controller
public class IndexController {

    @RequestMapping("/test")
    public String test(Model model){
        model.addAttribute("msg","<h1>hello,springboot</h1>");
        model.addAttribute("users", Arrays.asList("zhangmeng","liqiang","xugaochao"));
        return "test";
    }
}
