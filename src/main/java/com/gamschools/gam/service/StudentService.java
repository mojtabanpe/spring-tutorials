package com.gamschools.gam.service;

import com.gamschools.gam.dao.StudentRepository;
import com.gamschools.gam.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentWithId(int id) {
        Optional<Student> st = studentRepository.findById(id);
        if (st.isEmpty()) {
            throw new RuntimeException("student does not found!");
        } else {
            return st.get();
        }
    }

    public void save(Student st) {
        studentRepository.save(st);
    }

    public void deleteById(int id) {
        Optional<Student> st = studentRepository.findById(id);
        if (st.isPresent()) {
            studentRepository.deleteById(id);
        }
    }

}
