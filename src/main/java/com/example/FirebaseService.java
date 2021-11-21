package com.example;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class FirebaseService {

    public String createStudent(Student student) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("students").document(student.getEmail()).set(student);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public Student getStudent(String studentId) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection("students").document(studentId);
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot document = future.get();
        Student student;
        if (document.exists()) {
            student = document.toObject(Student.class);
            return student;
        }
        else {
            return null;
        }
    }

    public String updateStudent(Student student) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("students").document(student.getName()).set(student);
        return collectionsApiFuture.get().getUpdateTime().toString();

    }

    public String deleteStudent(String studentId) {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> writeResult = dbFirestore.collection("students").document(studentId).delete();
        return "Successfully delete " + studentId;
    }

}
