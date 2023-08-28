package com.dc18669.demo.controller;

import com.dc18669.demo.model.Teacher;
import com.dc18669.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tea")
public class LoginController {

    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @RequestMapping("/login")
    public String login(String username, String password, Model model) {
        System.out.println("进入 login 操作，，，，，，>>>");

        Teacher teacher = this.loginService.login(username, password);
        if (username.equals(teacher.getName())) {
            return "redirect:/students/find_student";
        }
        model.addAttribute("err", teacher.getName());
        System.out.println("退出 student 操作，，，，，，>>>");
        return "login";
    }
}
