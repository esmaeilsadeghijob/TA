package com.mapsa.springDataJPASample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {
    @Value("${ali.name}")
    String name;

    @Autowired
    BeanTest beanTest;

    @GetMapping("show")
    public void showValue() {
        System.out.println(name);
        System.out.println(beanTest.getName());
        beanTest.setName("new name");
        System.out.println(beanTest.getName());
    }


}
