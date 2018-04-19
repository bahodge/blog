package com.example.blog.models;

import javax.persistence.*;

@Entity
@Table(name = "dogs")
public class RarePupper {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "INT(11) UNSIGNED")
    private long id;

    @Column(nullable = false)
    private int age;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String state_residing;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState_residing() {
        return state_residing;
    }

    public void setState_residing(String state_residing) {
        this.state_residing = state_residing;
    }

    //    None
    public RarePupper() {
    }

//    All
    public RarePupper(long id, int age, String name, String state_residing) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.state_residing = state_residing;
    }

    public RarePupper(int age, String name, String state_residing) {
        this.age = age;
        this.name = name;
        this.state_residing = state_residing;
    }
}
