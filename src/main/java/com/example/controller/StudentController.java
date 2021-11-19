package com.example.controller;

import com.example.objects.Student;
import com.example.service.FirebaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
public class StudentController {

    @Autowired
    FirebaseService firebaseService;

    @GetMapping("/getStudentDetails")
    public Student getStudent(@RequestHeader() Integer id) throws ExecutionException, InterruptedException {
        return firebaseService.getStudentDetails(id);
    }
    @PostMapping("/createStudent")
    public String postStudent(@RequestBody Student student) throws InterruptedException, ExecutionException {
        return firebaseService.saveStudentDetails(student);
    }

    @PutMapping("/updateStudent")
    public String updateStudent(@RequestBody Student student) {
        return "Update user " + student.getName();
    }

    @DeleteMapping("/deleteStudent")
    public String deleteStudent(@RequestBody Student student) {
        return "Deleted user " + student.getName();
    }
}
