package com.nero.java_enterprise_project.service;

import com.nero.java_enterprise_project.model.User;

import java.util.List;
import java.util.Optional;


//Here is where i use UserRepository stuff
public interface UserService {
    User saveUser(User user);
    Optional<User> getUserById(long id);
    List<User> getAllUsers();
    void deleteUser(Long id);

}
