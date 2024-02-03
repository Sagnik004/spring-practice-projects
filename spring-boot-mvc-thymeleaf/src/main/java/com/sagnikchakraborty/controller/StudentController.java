package com.sagnikchakraborty.controller;

import com.sagnikchakraborty.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    @Value("${countries}") // Taking from properties file
    private List<String> countries;

    @Value("${programmingLanguages}") // Taking from properties file
    private List<String> programmingLanguages;

    @Value("${operatingSystems}") // Taking from properties file
    private List<String> operatingSystems;

    @GetMapping("/showStudentForm")
    public String showStudentForm(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        model.addAttribute("countries", countries);
        model.addAttribute("programmingLanguages", programmingLanguages);
        model.addAttribute("operatingSystems", operatingSystems);
        return "student-form";
    }

    @PostMapping("/registerStudent")
    public String registerStudent(@ModelAttribute("student") Student student) {
        System.out.println(student);
        return "student-register-confirmation";
    }
}
