package com.pauliausprojektas.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class TemplatesController {

    @GetMapping("/")
    public String login(){
        return "login";
    }
}
