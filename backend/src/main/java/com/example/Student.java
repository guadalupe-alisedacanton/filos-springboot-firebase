package com.example;

import org.springframework.stereotype.Component;


import java.util.Set;

@Component
public class Student {

    private String fullName;
    private String email;
    private String dob;
    private String major;
    private String year;
    private Set<Class> currentClasses;
    private String interests;
    private String linkedIn;
    private String insta;
    private String snap;

    public Student() {
    }

    public Student(String fullName, String email, String dob, String major, String year, String interests, String linkedIn, String insta, String snap) {
        this.fullName = fullName;
        this.email = email;
        this.dob = dob;
        this.major = major;
        this.year = year;
        this.interests = interests;
        this.linkedIn = linkedIn;
        this.insta = insta;
        this.snap = snap;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getLinkedIn() {
        return linkedIn;
    }

    public void setLinkedIn(String linkedIn) {
        this.linkedIn = linkedIn;
    }

    public String getInsta() {
        return insta;
    }

    public void setInsta(String insta) {
        this.insta = insta;
    }

    public String getSnap() {
        return snap;
    }

    public void setSnap(String snap) {
        this.snap = snap;
    }


    public String getInterests() {
        return interests;
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }

    public Set<Class> getCurrentClasses() {
        return currentClasses;
    }

    public void setCurrentClasses(Set<Class> currentClasses) {
        this.currentClasses = currentClasses;
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String name) {
        this.fullName = name;
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
                ", name='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", major='" + major + '\'' +
                ", year='" + year + '\'' +
                '}';
    }
}
