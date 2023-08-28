package com.dc18669.demo.controller;

import com.dc18669.demo.model.Student;
import com.dc18669.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(value = "/add_student", method = RequestMethod.POST)
    public String saveStudent(Student student, Model model) {
        System.out.println("进入 student 操作，添加 student 信息，，，，，>>>");
        if ("".equals(student.getName())) {
            model.addAttribute("empty", "学生姓名不能为空");
        } else if ("".equals(student.getSex())) {
            model.addAttribute("empty", "学生性别不能为空");
        } else if ((student.getAge() + "").isEmpty()) {
            model.addAttribute("empty", "学生年龄不能为空");
        } else {
            String res = this.studentService.saveStudent(student);
            if ("n".equals(res)) {
                model.addAttribute("empty", "未成功添加学生信息");
            }
        }

        System.out.println("退出 student 操作，保存完成 student 信息，，，，，>>>");
        return "redirect:/students/find_student";
    }

    @RequestMapping(value = "/find_student", method = RequestMethod.GET)
    public String findStudents(Model model) {
        System.out.println("进入 student 操作，查找 student 信息，，，，，>>>");

        List<Student> students = this.studentService.findStudents();
        if (students.isEmpty()) {
            model.addAttribute("no_result", "未查询到学生信息");
        }
        model.addAttribute("students", students);
        System.out.println("退出 student 操作，查询完成 student 信息，，，，，>>>");
        return "student";
    }

    @RequestMapping(value = "/find_student_name", method = RequestMethod.GET)
    public String findStudentByName(String name, Model model) {
        System.out.println("进入 student 操作，查找 student 信息，，，，，>>>");
        if ("".equals(name)) {
            return "redirect:/students/find_student";
        }

        List<Student> students = this.studentService.findStudentByName(name);
        if (students.isEmpty()) {
            model.addAttribute("no_result", "未查询到学生信息");
        }
        model.addAttribute("students", students);
        System.out.println("退出 student 操作，查询完成 student 信息，，，，，>>>");
        return "student";
    }
}
