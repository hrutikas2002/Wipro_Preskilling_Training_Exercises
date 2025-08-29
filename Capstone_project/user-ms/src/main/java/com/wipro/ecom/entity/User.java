package com.wipro.ecom.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name="fisrt_name")
    private String firstName;
    
    @Column(name="last_name")
    private String lastName;

    @Column(name="email_id",unique = true, nullable = false)
    private String emailId;

    @Column(name="user_id",unique = true, nullable = false)
    private String userId;

    @Column(name="password")
    private String passWord; // store encrypted password
    
    @Column(name="address")
    private String address;
    
    @Column(name="user_type")
    private int userType; // 0 = admin, 1 = customer
    
    @Column(name="is_loggedin")
    private boolean isLoggedIn = false;
}
