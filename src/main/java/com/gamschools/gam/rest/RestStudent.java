package com.gamschools.gam.rest;

import com.gamschools.gam.entity.Student;
import com.gamschools.gam.service.StudentService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RestStudent {

    private final StudentService studentService;

    @Autowired
    public RestStudent(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping("/students")
    public void saveStudent(@RequestBody Student student) {
        studentService.save(student);
    }

    @DeleteMapping("/students/{studentId}")
    public void deleteStudent(@PathVariable int studentId) {
        studentService.deleteById(studentId);
    }


}
