package com.example.FoodDeliveryApp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {
    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public AuthenticationManager authenticationManager(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder, HttpSecurity httpSecurity) throws Exception {
        AuthenticationManagerBuilder builder = httpSecurity.getSharedObject(AuthenticationManagerBuilder.class);
         builder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
         return builder.build();
    }
    @Bean
    public SecurityFilterChain configure(AuthenticationManager authenticationManager,  HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf(csrf->csrf.disable()).authorizeRequests().requestMatchers(HttpMethod.POST,"/user","/menu/createFromCSV").permitAll()
                .requestMatchers(HttpMethod.DELETE,"/user/**").hasAuthority("ADMIN")
                .anyRequest().authenticated().and().authenticationManager(authenticationManager).httpBasic(Customizer.withDefaults());
        return httpSecurity.build();

    }
}
