package com.example.greenlightoauth.service;

import com.example.greenlightoauth.repository.UserEntity;
import com.example.greenlightoauth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public boolean authenticate(String username, String password) {
        UserEntity userEntity = userRepository.findByUsername(username);

        if (userEntity != null) {
            // Ellenőrizze, hogy a beírt jelszó egyezik-e a hash-elt jelszóval az adatbázisban
            return passwordEncoder.matches(password, userEntity.getPassword());
        }
        return false;
    }
}

