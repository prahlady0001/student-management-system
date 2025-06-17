package com.example.studentcrud.web;

import org.springframework.ui.Model;


//import ch.qos.logback.core.model.Model;
import com.example.studentcrud.model.Student;
import com.example.studentcrud.service.java.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/students")
public class StudentWebController {
    @Autowired
    private StudentService studentService;

    // Show all students
    @GetMapping
    public String getAllStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "index";
    }

    // Show add student form
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("student", new Student());  // ✅ THIS LINE
        return "add-student";
    }

    // Save new student
    @PostMapping("/save")
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    // Show edit form
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Student student = studentService.getStudentById(id).orElseThrow();
        model.addAttribute("student", student);
        return "edit-student";
    }

    // Update student
    @PostMapping("/update")
    public String updateStudent(@ModelAttribute("student") Student student) {
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    // Delete student
    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return "redirect:/students";
    }
}








//this Student WebController for web Thymeleaf HTML pages