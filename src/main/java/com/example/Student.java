package com.example;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public class Student {

    private String studentId;
    private String name;
    private String email;
    private String major;
    private String year;
    private String password;
    private Set<Class> currentClasses;
    private List<String> interests;
    private String nationality;
    private String instagram;
    private String twitter;

    public Student() {
    }

    public Student(String studentId, String name, String email, String major, String year) {
        this.studentId = studentId;
        this.name = name;
        this.email = email;
        this.major = major;
        this.year = year;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getInterests() {
        return interests;
    }

    public void setInterests(List<String> interests) {
        this.interests = interests;
    }

    public Set<Class> getCurrentClasses() {
        return currentClasses;
    }

    public void setCurrentClasses(Set<Class> currentClasses) {
        this.currentClasses = currentClasses;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
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
