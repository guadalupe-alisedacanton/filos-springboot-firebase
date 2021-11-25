package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@SuppressWarnings("ALL")
@Component
public class Class {
    private String name;
    private String id;
    private List<Student> studentsEnrolled;
    private int studentCount;
    private String professor;
    private String location;

//    public Class(String name, String id, List<Student> studentsEnrolled, int studentCount, String professor, String location) {
//        this.name = name;
//        this.id = id;
//        this.studentsEnrolled = studentsEnrolled;
//        this.studentCount = studentCount;
//        this.professor = professor;
//        this.location = location;
//    }
//    public Class(String name, String id, int studentCount, String professor, String location) {
//        this.name = name;
//        this.id = id;
//        this.studentCount = studentCount;
//        this.professor = professor;
//        this.location = location;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Student> getStudentsEnrolled() {
        return studentsEnrolled;
    }

    public void setStudentsEnrolled(List<Student> studentsEnrolled) {
        this.studentsEnrolled = studentsEnrolled;
    }

    public int getStudentCount() {
        return studentCount;
    }

    public void setStudentCount(int studentCount) {
        this.studentCount = studentCount;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}

