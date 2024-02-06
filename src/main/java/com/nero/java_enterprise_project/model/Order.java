package com.nero.java_enterprise_project.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne //För en order, där jag är, kan det finnas många av för en user ManyOrdersTo1User
    @JoinColumn(name = "user_id")
    private User user;
    private LocalDateTime eventTime;
}
