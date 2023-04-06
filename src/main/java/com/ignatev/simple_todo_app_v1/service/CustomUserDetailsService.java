package com.ignatev.simple_todo_app_v1.service;

import com.ignatev.simple_todo_app_v1.entity.User;
import com.ignatev.simple_todo_app_v1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository
                .findUserByEmail(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User with " + username + " is not found"));
    }

    public User loadUserById(Long id) {
        System.out.println(id);
        return userRepository.findById(id).orElse(null);
    }
}
