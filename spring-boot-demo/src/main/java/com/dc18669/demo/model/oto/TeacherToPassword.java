package com.dc18669.demo.model.oto;

import com.dc18669.demo.model.Password;
import com.dc18669.demo.model.Teacher;

public class TeacherToPassword {

    private Teacher teacher;

    private Password password;

    public TeacherToPassword() {

    }

    public TeacherToPassword(Teacher teacher) {
        this.teacher = teacher;
    }

    public TeacherToPassword(Teacher teacher, Password password) {
        this.teacher = teacher;
        this.password = password;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Password getPassword() {
        return password;
    }

    public void setPassword(Password password) {
        this.password = password;
    }
}
