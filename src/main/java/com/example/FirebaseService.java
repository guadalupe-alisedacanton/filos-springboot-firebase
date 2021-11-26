package com.example;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import com.google.firestore.v1.Write;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class FirebaseService {


    // Student Functions
    public String createStudent(Student student) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("students").document(student.getEmail()).set(student);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public Student getStudent(String studentEmail) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection("students").document(studentEmail);
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
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("students").document(student.getEmail()).set(student);
        return collectionsApiFuture.get().getUpdateTime().toString();

    }

    public String addToStudentsClasses(String email, String classId) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection("students").document(email);
        ApiFuture<WriteResult> arrayUnion = documentReference.update("currentClasses", FieldValue.arrayUnion(classId));
        return arrayUnion.get().getUpdateTime().toString();

    }
    public String removeFromStudentsClasses(String email, String classId) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection("students").document(email);
        ApiFuture<WriteResult> arrayRemove = documentReference.update("currentClasses", FieldValue.arrayRemove(classId));
        return arrayRemove.get().getUpdateTime().toString();

    }

    public String addInterest(String email, String newInterest) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection("students").document(email);
        ApiFuture<WriteResult> arrayUnion = documentReference.update("interests", FieldValue.arrayUnion(newInterest));
        return arrayUnion.get().getUpdateTime().toString();
    }

    public String deleteStudent(String studentEmail) {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> writeResult = dbFirestore.collection("students").document(studentEmail).delete();
        return "Successfully deleted " + studentEmail;
    }


    // Class Functions
    public String createClass(Class class1) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("classes").document(class1.getId()).set(class1);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public Class getClass(String id) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection("classes").document(id);
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot document = future.get();
        Class class1;
        if (document.exists()) {
            class1 = document.toObject(Class.class);
            return class1;
        }
        else {
            return null;
        }
    }

    public String updateClass(Class class1) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("classes").document(class1.getId()).set(class1);
        return collectionsApiFuture.get().getUpdateTime().toString();

    }

    public String addStudentToClass(String classId, String studentEmail) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference classReference = dbFirestore.collection("classes").document(classId);
        ApiFuture<WriteResult> arrayUnion = classReference.update("studentsEnrolled", FieldValue.arrayUnion(studentEmail));
        final ApiFuture<WriteResult> updateFuture = classReference.update("studentCount", FieldValue.increment(1));
        return arrayUnion.get().getUpdateTime().toString();
    }
    public String dropStudentFromClass(String classId, String studentEmail) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference classReference = dbFirestore.collection("classes").document(classId);
        ApiFuture<WriteResult> arrayRemove = classReference.update("studentsEnrolled", FieldValue.arrayRemove(studentEmail));
        final ApiFuture<WriteResult> updateFuture = classReference.update("studentCount", FieldValue.increment(-1));
        return arrayRemove.get().getUpdateTime().toString();
    }

    public String addTA(String classId, String taName) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference classReference = dbFirestore.collection("classes").document(classId);
        ApiFuture<WriteResult> arrayUnion = classReference.update("taList", FieldValue.arrayUnion(taName));
        return arrayUnion.get().getUpdateTime().toString();
    }

    public String deleteClass(String id) {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> writeResult = dbFirestore.collection("classes").document(id).delete();
        return "Successfully deleted " + id;
    }
}
