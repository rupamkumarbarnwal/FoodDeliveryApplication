package com.example.FoodDeliveryApp.services;

import com.example.FoodDeliveryApp.entities.User.User;
import com.example.FoodDeliveryApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class OathService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByMail(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
      return   org.springframework.security.core.userdetails.User.builder().username(user.getMail()).password(user.getPassword()).build();

    }
}
