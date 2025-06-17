package com.example.studentcrud.service.java;


import com.example.studentcrud.model.Student;
import com.example.studentcrud.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // Indicates business logic layer
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    // Create or Update
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    // Read All
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // Read by ID
    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    // Delete
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

}
