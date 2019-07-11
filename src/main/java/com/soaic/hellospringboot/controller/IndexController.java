package com.soaic.hellospringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/index")
    public String hello(Model model) {
        model.addAttribute("name", "Soaic");
        return "index";
    }
}
