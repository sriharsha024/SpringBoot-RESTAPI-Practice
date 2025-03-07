package com.example.ThymeLeaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class MainController {

    @GetMapping("/home")
    public String loadHome(Model model) {
        model.addAttribute("name", "Java");
        return "home";
    }

    @GetMapping("/elvis")
    public String elvisExample(Model model) {
        model.addAttribute("isAdmin", true);
        model.addAttribute("gender", "M");
        return "elvis";
    }

    @GetMapping("/each")
    public String eachExample(Model model) {
        List<String> stringList = List.of("Aa", "Bb", "Cc", "Dd");
        model.addAttribute("list", stringList);
        return "each";
    }
    /*
    Elvis ? :
    if unless
    switch case
     */
}
