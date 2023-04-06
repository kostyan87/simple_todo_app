package com.ignatev.simple_todo_app_v1.service;

import com.ignatev.simple_todo_app_v1.entity.User;
import com.ignatev.simple_todo_app_v1.exception.UserExistException;
import com.ignatev.simple_todo_app_v1.exception.UsernameNotFoundException;
import com.ignatev.simple_todo_app_v1.repository.UserRepository;
import com.ignatev.simple_todo_app_v1.payload.SignUpRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
public class UserService {
    public static final Logger LOG = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public User createUser(SignUpRequest signUpRequest) {
        User user = new User(signUpRequest.getEmail(),
                passwordEncoder.encode(signUpRequest.getPassword()));

        try {
            LOG.info("Saving user {}", signUpRequest.getEmail());
            return userRepository.save(user);
        }
        catch (Exception e) {
            LOG.error("Error during registration. {}", e.getMessage());
            throw new UserExistException("The user " + user.getUsername() + " already exist." +
                    " Please check credentials");
        }
    }

    public User getUserByPrincipal(Principal principal) {
        String email = principal.getName();

        return userRepository
                .findUserByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException("Username not found with email " + email));
    }
}
