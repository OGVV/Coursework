package com.example.site.controllers;

import com.example.site.models.Marks;
import com.example.site.models.Students;
import com.example.site.repo.MarkRepository;
import com.example.site.repo.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class MarkController {

    @Autowired
    private MarkRepository markRepository;


    @GetMapping("/Mark/{id}")
    public String markInfo(@PathVariable(value = "id") long id, Model model) {
        Optional<Marks> mark = markRepository.findById(id);
        ArrayList<Marks> resMark = new ArrayList<>();
        mark.ifPresent(resMark::add);
        model.addAttribute("marks",resMark);
        return "Mark";
    }
    @GetMapping("/marks/add")
    public String marksadd(Model model) {
        return "mark-add";
    }
    @PostMapping("/marks/add")
    public String markslistadd(@RequestParam String Math, @RequestParam String Phisycs, @RequestParam String Economics, @RequestParam String Oop, @RequestParam String Politics, @RequestParam String Webdevelop, @RequestParam String Russian,@RequestParam long id, Model model){
        Marks marks=new Marks(Math,Phisycs,Economics,Oop,Politics,Webdevelop,Russian,id);
        markRepository.save(marks);
        return "redirect:/studentslist";
    }

    @GetMapping("/Mark/{id}/edit")
    public String marksEdit(@PathVariable(value = "id") long id, Model model) {
        if (!markRepository.existsById(id)) {
            return "redirect:/studentsist";
        }
        Optional<Marks> mark = markRepository.findById(id);
        ArrayList<Marks> resMark = new ArrayList<>();
        mark.ifPresent(resMark::add);
        model.addAttribute("marks",resMark);
        return "Mark-edit";
    }

    @PostMapping("/Mark/{id}/edit")
    public String marksupdate(@PathVariable(value = "id") long id,@RequestParam String Math, @RequestParam String Phisycs, @RequestParam String Economics, @RequestParam String Oop, @RequestParam String Politics, @RequestParam String Webdevelop, @RequestParam String Russian, Model model){
        Marks marks;
        marks = markRepository.findById(id).orElseThrow();
        marks.setMath(Math);
        marks.setPhisycs(Phisycs);
        marks.setWebdevelop(Webdevelop);
        marks.setRussian(Russian);
        marks.setPolitics(Politics);
        marks.setEconomics(Economics);
        marks.setOop(Oop);
        markRepository.save(marks);
        return "redirect:/studentslist";
    }
}