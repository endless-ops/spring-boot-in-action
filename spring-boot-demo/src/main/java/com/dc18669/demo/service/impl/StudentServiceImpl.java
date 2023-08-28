package com.dc18669.demo.service.impl;

import com.dc18669.demo.model.Student;
import com.dc18669.demo.repository.StudentRepository;
import com.dc18669.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @Override
    public String saveStudent(Student student) {
        Student save = this.studentRepository.save(student);
        System.out.println(".. save .." + save.getName());
        if ((save.getId() + "").isEmpty()) {
            return "n";
        }else {
            return "y";
        }
    }

    @Override
    public List<Student> findStudents() {
        return this.studentRepository.findAll();
    }

    @Override
    public List<Student> findStudentByName(String name) {
        return this.studentRepository.findStudentByName(name);
    }
}
