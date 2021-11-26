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
    public Student getStudent(@RequestParam String studentEmail) throws InterruptedException, ExecutionException {
        return firebaseService.getStudent(studentEmail);
    }

    @PutMapping("/updateStudent")
    public String updateStudent(@RequestBody Student student) throws InterruptedException, ExecutionException {
        return firebaseService.updateStudent(student);
    }

    @PutMapping("/addCurrentClasses")
    public String addCurrentClasses(@RequestParam String email, @RequestParam String classId) throws InterruptedException, ExecutionException {
        firebaseService.addStudentToClass(classId, email);
        return firebaseService.addToStudentsClasses(email, classId);
    }

    @PutMapping("/removeCurrentClasses")
    public String removeCurrentClasses(@RequestParam String email, @RequestParam String classId) throws InterruptedException, ExecutionException {
        firebaseService.dropStudentFromClass(classId, email);
        return firebaseService.removeFromStudentsClasses(email, classId);
    }

    @PutMapping("/addInterest")
    public String addInterest(@RequestParam String email, @RequestParam String newInterest) throws InterruptedException, ExecutionException {
        return firebaseService.addInterest(email, newInterest);
    }

    @DeleteMapping("/deleteStudent")
    public String deleteStudent(@RequestParam String studentEmail) throws InterruptedException, ExecutionException {
        return firebaseService.deleteStudent(studentEmail);
    }

    @GetMapping("/test")
    public ResponseEntity<String> testGetEndpoint() {
        return ResponseEntity.ok("Test Get Endpoint is working!");
    }
}
