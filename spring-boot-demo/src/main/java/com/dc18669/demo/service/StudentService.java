package com.dc18669.demo.service;

import com.dc18669.demo.model.Student;

import java.util.List;

public interface StudentService {

    String saveStudent(Student student);

    List<Student> findStudents ();

    List<Student> findStudentByName(String name);
}
