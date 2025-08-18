package com.example.demo.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class teachers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int age;
    private String email;

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    private List<students> students;


    public teachers() {}

    public teachers(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }


    public Long getId() {
        return id;
    }
    public void setId(Long id) { this.id = id; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
