package com.example;

import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
public class ClassController {
    public FirebaseService firebaseService;

    public ClassController(FirebaseService firebaseService) {
        this.firebaseService = firebaseService;
    }

    @PostMapping("/createClass")
    public String createClass(@RequestBody Class class1) throws InterruptedException, ExecutionException {
//        return firebaseService.saveStudentDetails(student);
        return firebaseService.createClass(class1);
    }

    @GetMapping("/getClass")
    public Class getClass(@RequestParam String id) throws InterruptedException, ExecutionException {
        return firebaseService.getClass(id);
    }

    @PutMapping("/updateClass")
    public String updateClass(@RequestBody Class class1) throws InterruptedException, ExecutionException {
        return firebaseService.updateClass(class1);
    }

    @DeleteMapping("/deleteClass")
    public String deleteClass(@RequestParam String id) throws InterruptedException, ExecutionException {
        return firebaseService.deleteClass(id);
    }
}
