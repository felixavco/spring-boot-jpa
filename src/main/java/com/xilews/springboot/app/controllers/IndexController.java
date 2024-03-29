package com.xilews.springboot.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    
    @GetMapping({"/", "clients", "client"})
    public String index() {

        return "forward:client/list";
    }
}