package com.example.blog.models;

import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    private long id;

//    Each user must have a unique username + email
    @Column(nullable = false, columnDefinition = "UNIQUE")
//    @Size(min = 3, max = 20, message = "Username must be 3 - 20 characters long")
    private String username;

    @Column(nullable = false, columnDefinition = "UNIQUE")
//    @Email(message = "Email must be valid")
    private String email;

    @Column(nullable = false)
//    @Size(min = 3, max = 20, message = "Password must be 3 - 20 characters long")
    private String password;

//    Copy constructor
    public User(User copy){
        this.id = copy.id;
        this.email = copy.email;
        this.username = copy.username;
        this.password = copy.password;
    }

    public User() {
    }

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
