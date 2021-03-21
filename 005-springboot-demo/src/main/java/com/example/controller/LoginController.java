package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @RequestMapping("/user/login")
    //@ResponseBody//将controller的方法返回的对象通过适当的转换器转换为指定的格式之后，写入到response对象的body区
    public String login(@RequestParam("username") String username, @RequestParam("password") String password
    , Model model, HttpSession session){//@RequestParam如果html中传入的值和形参的名相同可以不写
        //具体业务，判断用户名密码是否正确
        if(!StringUtils.isEmpty(username) && "123456".equals(password)){
            //return "dashboard"; 会在浏览器的地址栏泄露隐私
            //登录成功放一个session
            session.setAttribute("loginUser",username);
            return "redirect:/main.html";
        }else{
            model.addAttribute("msg","用户名或密码错误");
            return "index";
        }
    }
}
