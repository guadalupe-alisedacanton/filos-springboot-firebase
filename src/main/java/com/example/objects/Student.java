package com.example.objects;

import org.springframework.stereotype.Component;

@Component
public class Student {

    private int id;
    private String name;
    private String email;
    private String major;
    private String year;


    public Student() {
    }

    public Student(int id, String name, String email, String major, String year) {
        this.id = id;
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
        return id;
    }
    public String getStringId() {
        return ""+id;
    }

    public void setId(int id) {
        this.id = id;
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
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", major='" + major + '\'' +
                ", year='" + year + '\'' +
                '}';
    }
}
