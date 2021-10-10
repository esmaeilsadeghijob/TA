package com.mapsa.demo.spring.config;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class HomeController {


   @GetMapping("/")
    public String index(){

        return "index";
    }
    @GetMapping("/product")
    public String product(){
        //
        return "product";
    }

    @GetMapping("/heloo")
    public String heloo(HttpServletRequest req, Model model) {
        String name = req.getParameter("name");
        String pass = req.getParameter("pass");
        if (pass.equals("admin")) {
            String msg = "heloo heloo" + name;
            model.addAttribute("message", msg);
            return "product";
        } else {
            String msg = "sorry" + name;
            model.addAttribute("message", msg);
            return "error";
        }
    }

    @GetMapping("/phone")
    public String phone(){
        //
        return "phone";
    }

    @GetMapping("/laptop")
    public String laptob(){
        //
        return "laptop";
    }



}
