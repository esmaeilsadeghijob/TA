package com.mapsa.dotin.controller;

import com.mapsa.dotin.model.User;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/welcome")
public class WelcomeController {

    @GetMapping("sign-up")
    public ModelAndView signUp(){
        String message = "<br><div style='text-align:center;'>"
                + "<h3>********** Hello World, Spring MVC Dotin Project</h3>This message is " +
                "coming from WelcomeController.java **********</div><br><br>";
        return new ModelAndView("sign-up", "message", message);
    }

    @PostMapping("sign-up")
    public ModelAndView signUp(@RequestBody User user){

        return new ModelAndView();
    }
}
