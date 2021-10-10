package com.mapsa.demo.spring.config;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

  @GetMapping("/user")
    public String users(Model model){
        //
        return "user";
    }
}
