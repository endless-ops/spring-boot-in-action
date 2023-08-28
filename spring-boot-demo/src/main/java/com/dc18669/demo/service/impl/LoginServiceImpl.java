package com.dc18669.demo.service.impl;

import com.dc18669.demo.model.Password;
import com.dc18669.demo.model.Teacher;
import com.dc18669.demo.model.oto.TeacherToPassword;
import com.dc18669.demo.repository.LoginRepository;
import com.dc18669.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class LoginServiceImpl implements LoginService {

    private final LoginRepository loginRepository;

    @Autowired
    public LoginServiceImpl(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    @Override
    public Teacher login(String name, String password) {
        Teacher teacher = new Teacher();
        TeacherToPassword tp = this.loginRepository.findByName(name);
        if (Objects.isNull(tp) || Objects.isNull(tp.getTeacher())) {
            teacher.setName("此用户不存在");
            return teacher;
        } else {
            if (!Objects.isNull(tp.getPassword()) && !"".equals(tp.getPassword().getPassword()) && tp.getPassword().getPassword().equals(password)) {
                return tp.getTeacher();
            } else {
                teacher.setName("用户名或密码不正确");
                return teacher;
            }
        }

    }
}
