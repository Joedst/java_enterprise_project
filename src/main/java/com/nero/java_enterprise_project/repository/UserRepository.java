package com.nero.java_enterprise_project.repository;

import com.nero.java_enterprise_project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



    @Repository
    public interface UserRepository extends JpaRepository<User, Long>{ //extends JPA repository ger mig save, findById etc.

    }

