package edu.etec.thymeleafdashboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dashboard")
public class StudentController {
    @GetMapping("/viewStudent")
    public String index() {
        return "viewStudent";
    }
    @GetMapping("/addStudent")
    public String addStudent() {
        return "addStudent";
    }
    @GetMapping("/updateStudent")
    public String updateStudent() {
        return "updateStudent";
    }
}
