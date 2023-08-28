package com.dc18669.demo.config;


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
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // http.csrf(Customizer.withDefaults());
        http.authorizeHttpRequests(
                        (auth) -> {
                            auth.requestMatchers("/css/**", "/js/**", "/images/**").permitAll();
                            auth.anyRequest().authenticated();
                        }
                ).formLogin(form -> form.loginPage("/ot/login")
                        .loginProcessingUrl("/tea/login")
                        .defaultSuccessUrl("/students/find_student", true)
                        .permitAll())
                .csrf(
                        AbstractHttpConfigurer::disable
                );
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService () {
        // 基于 InMemoryUserDetailsManager 类的用户存储
        // 方式一：
        // UserDetails user = User.builder()
        //         .username("user") // 用户名
        //         .password("{bcrypt}$2a$10$GRLdNijSQMUvl/au9ofL.eDwmoohzzS7.rmNSJZ.0FxO/BTk76klW") // 密码
        //         .roles("USER") // 角色
        //         .build();

        // 方式二：
        User.UserBuilder users = User.withDefaultPasswordEncoder();
        UserDetails user = users
                .username("user")
                .password("password")
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user);
    }

}
