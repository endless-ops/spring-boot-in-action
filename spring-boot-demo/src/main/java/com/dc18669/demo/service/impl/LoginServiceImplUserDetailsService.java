package com.dc18669.demo.service.impl;


import com.dc18669.demo.model.oto.TeacherToPassword;
import com.dc18669.demo.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImplUserDetailsService implements UserDetailsService {

    private final LoginRepository loginRepository;

    @Autowired
    public LoginServiceImplUserDetailsService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        TeacherToPassword tp = this.loginRepository.findByName(username);
        if (tp == null) {
            throw new UsernameNotFoundException("用户名或密码错误");
        }
        // return new User(tp.getTeacher().getName(), tp.getPassword().getPassword(), true, true,
        //         true, true, null);

        return User.withUsername(tp.getTeacher().getName()).password(tp.getPassword().getPassword()).roles("USER").build();
    }
}
