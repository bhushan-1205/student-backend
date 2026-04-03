package com.student_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.student_service.entity.Student;
import com.student_service.services.StudentService;

@RestController
@RequestMapping("/students")
@CrossOrigin("*")

public class StudentController {

     @Autowired
    private StudentService service;

    @PostMapping
    public Student add(@RequestBody Student s) {
        return service.add(s);
    }

    @GetMapping
    public List<Student> getAll() {
        return service.getAll();
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Deleted";
    }

    @PutMapping("/{id}")
    public Student update(@PathVariable Long id, @RequestBody Student s) 
    {
     return service.update(id, s);
    }

    @GetMapping("/search")
    public List<Student> search(@RequestParam String name) {
    return service.searchByName(name);
    }

}
