package com.dc18669.demo.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                        (auth) -> {
                            auth.requestMatchers("/css/**", "/js/**", "/images/**").permitAll();
                            auth.anyRequest().authenticated();
                        }
                ).formLogin(form -> form.loginPage("/ot/login")
                        .loginProcessingUrl("/tea/login")
//                        .defaultSuccessUrl("/students/find_student")
                        .permitAll())
                .csrf(
                        AbstractHttpConfigurer::disable
                );
        return http.build();
    }
}
