package com.example.demo.item;

import com.example.demo.student.Student;

import javax.persistence.*;

@Entity
public class Item {

    @Id
    @GeneratedValue
    Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name="student_id")
    private Student student;

    public Item() {
    }

    public Item(String name, Student student) {
        this.name = name;
        this.student = student;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
