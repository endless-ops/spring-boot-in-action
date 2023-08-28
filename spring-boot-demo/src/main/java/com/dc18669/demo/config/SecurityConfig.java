package com.dc18669.demo.config;


import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;
import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // http.csrf(Customizer.withDefaults());
        http.authorizeHttpRequests(
                        (auth) -> {
                            auth.requestMatchers("/css/**", "/js/**", "/images/**").permitAll();
                            // anyRequest : 任意请求
                            // authenticated : 指定请求需要认证身份
                            // permitAll : 允许指定的请求进行访问
                            auth.anyRequest().authenticated();
                        }
                )
                // formLogin ： 开启表单登录
                .formLogin(form -> form
                        // loginPage ： 跳转指定的登录页面
                        .loginPage("/ot/login")
                        // loginProcessingUrl ： 提交表单接口。此值和 表单的action属性值一致。
                        .loginProcessingUrl("/tea/login")
                        // defaultSuccessUrl ： 登陆成功后重定向的路径
                        .defaultSuccessUrl("/students/find_student", true)
                        .permitAll())
                .csrf(
                        AbstractHttpConfigurer::disable
                );
        return http.build();
    }

    // @Bean
    // public UserDetailsService userDetailsService () {
    //     // 基于 InMemoryUserDetailsManager 类的用户存储
    //     // 方式一：
    //     // UserDetails user = User.builder()
    //     //         .username("user") // 用户名
    //     //         .password("{bcrypt}$2a$10$GRLdNijSQMUvl/au9ofL.eDwmoohzzS7.rmNSJZ.0FxO/BTk76klW") // 密码
    //     //         .roles("USER") // 角色
    //     //         .build();
    //
    //     // 方式二：
    //     User.UserBuilder users = User.withDefaultPasswordEncoder();
    //     UserDetails user = users
    //             .username("user")
    //             .password("password")
    //             .roles("USER")
    //             .build();
    //     return new InMemoryUserDetailsManager(user);
    // }


    @Bean
    public DataSource dataSource() {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        //设置数据库连接参数
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test");
        dataSource.setUser("root");
        dataSource.setPassword("root");
        return dataSource;
    }

    @Bean
    UserDetailsManager users(DataSource dataSource) {
        UserDetails user = User.builder()
                .username("user")
                .password("{bcrypt}$2a$10$GRLdNijSQMUvl/au9ofL.eDwmoohzzS7.rmNSJZ.0FxO/BTk76klW")
                .roles("USER")
                .build();
        UserDetails admin = User.builder()
                .username("admin")
                .password("{bcrypt}$2a$10$GRLdNijSQMUvl/au9ofL.eDwmoohzzS7.rmNSJZ.0FxO/BTk76klW")
                .roles("USER", "ADMIN")
                .build();
        JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
        users.createUser(user);
        users.createUser(admin);
        return users;
    }

}
