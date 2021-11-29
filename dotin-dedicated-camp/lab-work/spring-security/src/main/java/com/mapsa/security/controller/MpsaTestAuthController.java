package com.mapsa.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class MpsaTestAuthController {

    @GetMapping
    public String getTest() {
        return "success";
    }
}
