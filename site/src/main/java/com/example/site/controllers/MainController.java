package com.example.site.controllers;

import com.example.site.models.Students;
import com.example.site.repo.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class MainController {

    @Autowired
    private StudentsRepository studentsRepository;


    @GetMapping("/")
    public String home( Model model) {
        model.addAttribute("title", "BNTU");
        return "home";
    }

}
