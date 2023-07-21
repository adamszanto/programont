package com.example.securityjwt.service;

import com.example.securityjwt.repository.UserEntity;
import com.example.securityjwt.repository.UserRepository;
import com.example.securityjwt.security.UserPasswordEncoder;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService{
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserPasswordEncoder userPasswordEncoder;

    @Override
    public User createUser(User requestUser) {
        UserEntity user = modelMapper.map(requestUser, UserEntity.class);
        user.setPassword(userPasswordEncoder.encode(requestUser.getPassword()));
        UserEntity createdUser = userRepository.save(user);
        return modelMapper.map(createdUser, User.class);
    }
}
