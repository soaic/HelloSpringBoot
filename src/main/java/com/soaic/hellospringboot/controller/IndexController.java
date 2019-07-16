package com.soaic.hellospringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;

@Controller
public class IndexController {

    @ApiIgnore
    @RequestMapping("/index")
    public String hello(Model model) {
        model.addAttribute("name", "Soaic");
        return "index";
    }
}
