package com.example.demo.student;

import com.example.demo.address.Address;
import com.example.demo.course_registration.CourseRegistration;
import com.example.demo.item.Item;
import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.Set;

@Entity(name="student")
public class Student {
    @Id
    @Column(name = "id")
    @GeneratedValue
    private Long id;
    private String lastName;
    private String firstName;
    private String email;
    private int age;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonIgnoreProperties(value = { "student" }, allowSetters = true)
    private Address address;

    @OneToMany(mappedBy = "course")
    Set<CourseRegistration> registrations;

    @OneToMany(mappedBy = "student")
    @JsonUnwrapped
    private Set<Item> items;

    public Student() {
    }

    public Student(Long id, String lastName, String firstName, String email, int age) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.age = age;
    }

    public Student(String lastName, String firstName, String email, int age) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<CourseRegistration> getRegistrations() {
        return registrations;
    }

    public void setRegistrations(Set<CourseRegistration> registrations) {
        this.registrations = registrations;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}
