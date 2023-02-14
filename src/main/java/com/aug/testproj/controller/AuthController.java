package com.aug.testproj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/auth")
public class AuthController {

    //переход на страницу с формой авторизации
    @GetMapping("/login")
    public String showLoginPage(){
        return "login";
    }
}
