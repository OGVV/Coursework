package com.example.site.controllers;

import com.example.site.models.Students;
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
public class StudentsController {

    @Autowired
    private StudentsRepository studentsRepository;

    @GetMapping("/studentslist")
    public String studentslist( Model model) {
        Iterable<Students> students = studentsRepository.findAll();
        model.addAttribute("students",students);
        return "students-list";
    }
    @GetMapping("/student/add")
    public String studentadd( Model model) {
        return "student-add";
    }
   @PostMapping("/student/add")
    public String studentlistadd(@RequestParam String Fname,@RequestParam String Lname,@RequestParam String Patron,@RequestParam String Email,@RequestParam String Adress,@RequestParam String Faculty,@RequestParam String Form,@RequestParam String Special,@RequestParam String Number, Model model){
        Students students;
        students = new Students(Fname,Lname,Patron,Email,Adress,Faculty,Form,Special,Number);
        studentsRepository.save(students);
        return "redirect:/studentslist";
    }

    @GetMapping("/student/{id}")
    public String studentInfo(@PathVariable(value = "id") long id, Model model) {
        if (!studentsRepository.existsById(id)) {
            return "redirect:/studentsist";
        }
        Optional<Students> student = studentsRepository.findById(id);
        ArrayList<Students> res = new ArrayList<>();
        student.ifPresent(res::add);
        model.addAttribute("students",res);
        return "student";
    }

    @GetMapping("/student/{id}/edit")
    public String studentEdit(@PathVariable(value = "id") long id, Model model) {
        if (!studentsRepository.existsById(id)) {
            return "redirect:/studentsist";
        }
        Optional<Students> student = studentsRepository.findById(id);
        ArrayList<Students> res = new ArrayList<>();
        student.ifPresent(res::add);
        model.addAttribute("students",res);
        return "student-edit";
    }

    @PostMapping("/student/{id}/edit")
    public String studentlistupdate(@PathVariable(value = "id") long id,@RequestParam String Fname,@RequestParam String Lname,@RequestParam String Patron,@RequestParam String Email,@RequestParam String Adress,@RequestParam String Faculty,@RequestParam String Form,@RequestParam String Special,@RequestParam String Number, Model model){
        Students students;
        students = studentsRepository.findById(id).orElseThrow();
        students.setFname(Fname);
        students.setLname(Lname);
        students.setPatrone(Patron);
        students.setEmail(Email);
        students.setAdress(Adress);
        students.setFaculty(Faculty);
        students.setForm(Form);
        students.setSpecial(Special);
        students.setNumber(Number);
        studentsRepository.save(students);
        return "redirect:/studentslist";
    }

    @PostMapping("/student/{id}/remove")
    public String studentlistdelete(@PathVariable(value = "id") long id, Model model){
        Students students;
        students = studentsRepository.findById(id).orElseThrow();
        studentsRepository.delete(students);
        return "/complete-delete";
    }
}
