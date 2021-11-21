package com.example;

import org.springframework.stereotype.Component;

@Component
public class Student {

    private int studentId;
    private String name;
    private String email;
    private String major;
    private String year;


    public Student() {
    }

    public Student(int studentId, String name, String email, String major, String year) {
        this.studentId = studentId;
        this.name = name;
        this.email = email;
        this.major = major;
        this.year = year;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getId() {
        return studentId;
    }

    public void setId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", major='" + major + '\'' +
                ", year='" + year + '\'' +
                '}';
    }
}
