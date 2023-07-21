package com.example.securityjwt.security;

import com.example.securityjwt.repository.UserEntity;
import com.example.securityjwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public User loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<UserEntity> userEntityOpt = userRepository.findFirstByEmail(email);
        if(userEntityOpt.isEmpty()) {
            throw new UsernameNotFoundException("User not found.");
        }
        UserEntity userEntity = userEntityOpt.get();
        return new User(userEntity.getEmail(), userEntity.getPassword(), new ArrayList<>());
    }
}
