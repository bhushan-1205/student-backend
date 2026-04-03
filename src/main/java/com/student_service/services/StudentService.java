package com.student_service.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student_service.entity.Student;
import com.student_service.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repo;

    public Student add(Student s) {
        return repo.save(s);
    }

    public List<Student> getAll() {
        return repo.findAll();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public Student update(Long id, Student s) {
        Student existing = repo.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
        existing.setName(s.getName());
        existing.setEmail(s.getEmail());
        existing.setCourse(s.getCourse());
        return repo.save(existing);
    }

    public List<Student> searchByName(String name) {
        return repo.findByNameContaining(name);
    }
}



