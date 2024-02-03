package com.sagnikchakraborty.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    @GetMapping("/displayform")
    public String displayHelloWorldInputForm() {
        return "helloworld-form";
    }

    @GetMapping("/processForm")
    public String processHelloWorldForm() {
        return "helloworld";
    }

    @PostMapping("/processForm2")
    public String processHelloWorldForm2(@RequestParam("studentName") String studentName,
                                         Model model) {
        String updatedName = studentName.trim().toUpperCase();
        String result = "Hello! " + updatedName;
        model.addAttribute("message", result);
        return "helloworld-shout";
    }
}
