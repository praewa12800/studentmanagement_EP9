package com.klednatee.studentmanagement.controller;

import com.klednatee.studentmanagement.dto.StudentDto;
import com.klednatee.studentmanagement.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }
    @GetMapping("/students")
    public String ListStudent(Model model){
        List<StudentDto> students = studentService.getAllStudents();
        model.addAttribute("Students",students);
        return "students";
    }

    @GetMapping("/students/new")
    public String newStudents(Model model){
        StudentDto studentDto= new StudentDto();
        model.addAttribute("students",studentDto);
        return "create-students";
    }
}
