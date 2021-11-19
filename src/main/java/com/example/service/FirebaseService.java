package com.example.service;

import com.example.objects.Student;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import com.google.firestore.v1.Write;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class FirebaseService {

    @Autowired
    private Firestore firestore;

    private CollectionReference getStudentCollection() {
        return firestore.collection("students");
    }

    public String saveStudentDetails(Student student) throws InterruptedException, ExecutionException {
        ApiFuture<WriteResult> collectionApiFuture = getStudentCollection().document(student.getStringId()).set(student);
        return collectionApiFuture.get().getUpdateTime().toString();
    }
    public Student getStudentDetails(Integer id) throws InterruptedException, ExecutionException {
        DocumentReference documentRef = getStudentCollection().document(id.toString());
        ApiFuture<DocumentSnapshot> future = documentRef.get();
        DocumentSnapshot document = future.get();
        if (document.exists()) {
            return document.toObject(Student.class);
        }
        else {
            return null;
        }
    }


//    public String saveStudentDetails(Student student) throws InterruptedException, ExecutionException {
//        Firestore dbFirestore = FirestoreClient.getFirestore();
//        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("students").document(student.getId()).set();
//        return collectionsApiFuture.get().getUpdateTime().toString();
//    }
//    public Student getStudentDetails(Integer id) throws InterruptedException, ExecutionException {
//        Firestore dbFirestore = FirestoreClient.getFirestore();
//        DocumentReference documentRef = dbFirestore.collection("students").document(id.toString());
//        ApiFuture<DocumentSnapshot> future = documentRef.get();
//        DocumentSnapshot document = future.get();
//        if (document.exists()) {
//            return document.toObject(Student.class);
//        }
//        else {
//            return null;
//        }
//    }
//
//    public String updateStudentDetails(Student student) {
//        Firestore dbFirestore = FirestoreClient.getFirestore();
//        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("students").document(student.getId());
//        return collectionsApiFuture.get().getUpdateTime().toString();
//    }
}
