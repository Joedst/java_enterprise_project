package com.nero.java_enterprise_project.service.impl;


import com.nero.java_enterprise_project.model.User;
import com.nero.java_enterprise_project.repository.UserRepository;
import com.nero.java_enterprise_project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

@Autowired
    public UserServiceImpl(PasswordEncoder passwordEncoder, UserRepository userRepository) {
    this.passwordEncoder = passwordEncoder;
    this.userRepository = userRepository;
    }


    @Override
    public User saveUser(User user) {
user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public Optional<User> getUserById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);

    }
}
