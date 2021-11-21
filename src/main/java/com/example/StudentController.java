package com.example;

import com.example.Student;
import com.example.FirebaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;
import java.util.function.IntToDoubleFunction;

@RestController
public class StudentController {

    public FirebaseService firebaseService;

    public StudentController(FirebaseService firebaseService) {
        this.firebaseService = firebaseService;
    }

    @PostMapping("/createStudent")
    public String createStudent(@RequestBody Student student) throws InterruptedException, ExecutionException {
//        return firebaseService.saveStudentDetails(student);
        return firebaseService.createStudent(student);
    }

    @GetMapping("/getStudent")
    public Student getStudent(@RequestParam String studentId) throws InterruptedException, ExecutionException {
        return firebaseService.getStudent(studentId);
    }

    @PutMapping("/updateStudent")
    public String updateStudent(@RequestBody Student student) throws InterruptedException, ExecutionException {
        return firebaseService.updateStudent(student);
    }

    @DeleteMapping("/deleteStudent")
    public String deleteStudent(@RequestParam String studentId) throws InterruptedException, ExecutionException {
        return firebaseService.deleteStudent(studentId);
    }

    @GetMapping("/test")
    public ResponseEntity<String> testGetEndpoint() {
        return ResponseEntity.ok("Test Get Endpoint is working!");
    }
}
