package com.example.demo.address;

import com.example.demo.student.Student;

import javax.persistence.*;

@Entity(name="address")
public class Address {
    @Id
    @Column(name = "id")
    @GeneratedValue
    private long id;
    private String addressString;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAddressString() {
        return addressString;
    }

    public void setAddressString(String addressString) {
        this.addressString = addressString;
    }

    public Student getStudent() {
        return student;
    }

    @OneToOne(mappedBy = "address")
    @JoinColumn(name = "student_id")
    private Student student;

    public Address() {
    }

    public Address(String addressString) {
        this.addressString = addressString;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Address{" + "id=" + id + ", addressString='" + addressString + '\'' + '}';
    }
}
