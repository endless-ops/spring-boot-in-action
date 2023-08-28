package com.dc18669.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ot")
public class OtherController {

    @RequestMapping("/login")
    public String toLogin() {
        return "login";
    }
}
