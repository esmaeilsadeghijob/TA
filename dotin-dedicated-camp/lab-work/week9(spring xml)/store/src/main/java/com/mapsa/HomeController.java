package com.mapsa;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class HomeController {

    private Map<String,String> users=new HashMap<>();

    @RequestMapping("/")
    public String index(){
        //
        return "index";
    }
    @RequestMapping("/product")
    public String product(){
        //
        return "product";
    }

    @RequestMapping("/heloo")
    public String heloo(HttpServletRequest req, Model model) {
        String name = req.getParameter("name");
        String pass = req.getParameter("pass");
        if (users.get(name).equals(pass)){

            String msg = "heloo heloo" + name;
            model.addAttribute("message", msg);
            return "product";
        } else {
            String msg = "sorry" + name + "......";
            model.addAttribute("message", msg);
            return "error";
        }
    }
        @RequestMapping("/phone")
        public String phone(){
            //
            return "phone";
        }

    @RequestMapping("/pc")
    public String pc(){
        //
        return "pc";
    }
    @RequestMapping("/laptop")
    public String laptop(){
        //
        return "laptop";
    }
@RequestMapping("register")
    public String register(HttpServletRequest req, Model model){
        String name = req.getParameter("name");
        String pass = req.getParameter("pass");
        users.put(name,pass);
        String msg="heloo succesful"+name;
        model.addAttribute("message",msg);
        return "hello";
    }
    @RequestMapping("registerpage")
    public String registerpage(HttpServletRequest req, Model model){

        return "register";
    }
}
