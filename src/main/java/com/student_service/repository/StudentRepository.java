package com.student_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student_service.entity.Student;

public interface StudentRepository  extends JpaRepository<Student, Long> {

    List<Student> findByNameContaining(String name);

}
