package com.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import com.google.firestore.v1.Document;
import com.google.firestore.v1.Write;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
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

    public String getStudentsClasses(String studentEmail) throws InterruptedException, ExecutionException, JsonProcessingException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference studentReference = dbFirestore.collection("students").document(studentEmail);
        ApiFuture<DocumentSnapshot> documentSnapshotApiFuture = studentReference.get();
        DocumentSnapshot documentSnapshot = documentSnapshotApiFuture.get();
        Object objectArray = documentSnapshot.get("currentClasses");
        String strArray = objectArray.toString().replaceAll("[\\[\\]]", "");
        List<String> ids = new ArrayList<>(Arrays.asList(strArray.split(",")));
        String json = "[";
        ObjectMapper mapper = new ObjectMapper();
        for (int i = 0; i < ids.size(); i++) {
            DocumentReference classReference = dbFirestore.collection("classes").document(ids.get(i).trim());
            ApiFuture<DocumentSnapshot> classFuture = classReference.get();
            DocumentSnapshot classDocumentSnapshot = classFuture.get();
            Class c = classDocumentSnapshot.toObject(Class.class);
            json += mapper.writerWithDefaultPrettyPrinter().writeValueAsString(c);
            json += ",";
        }
        StringBuilder sb = new StringBuilder(json);
        sb.deleteCharAt(sb.length()-1);
        json = sb.toString();
        json += "]";
        return json;
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

    public String getAllClasses() throws InterruptedException, ExecutionException, JsonProcessingException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<QuerySnapshot> future = dbFirestore.collection("classes").get();
        List<QueryDocumentSnapshot> documents = future.get().getDocuments();
        ObjectMapper mapper = new ObjectMapper();
        String json = "[";
        for (QueryDocumentSnapshot doc : documents) {
            DocumentReference classReference = dbFirestore.collection("classes").document(doc.getId());
            ApiFuture<DocumentSnapshot> documentSnapshotApiFuture = classReference.get();
            DocumentSnapshot documentSnapshot = documentSnapshotApiFuture.get();

            Class c = documentSnapshot.toObject(Class.class);
            json += mapper.writerWithDefaultPrettyPrinter().writeValueAsString(c);
            json += ",";

        }
        StringBuilder sb = new StringBuilder(json);
        sb.deleteCharAt(sb.length()-1);
        json = sb.toString();
        json += "]";
        return json;
    }

    public String getEnrolledStudents(String id) throws InterruptedException, ExecutionException, JsonProcessingException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference classReference = dbFirestore.collection("classes").document(id);
        ApiFuture<DocumentSnapshot> documentSnapshotApiFuture = classReference.get();
        DocumentSnapshot documentSnapshot = documentSnapshotApiFuture.get();
        Object objectArray = documentSnapshot.get("studentsEnrolled");
//        List<Object> strArray = Arrays.asList(objectArray);
        String strArray = objectArray.toString().replaceAll("[\\[\\]]", "");
        List<String> emails = new ArrayList<>(Arrays.asList(strArray.split(",")));
        String json = "[";
        ObjectMapper mapper = new ObjectMapper();
        for (int i = 0; i < emails.size(); i++) {
            DocumentReference studentReference = dbFirestore.collection("students").document(emails.get(i).trim());
            ApiFuture<DocumentSnapshot> studentFuture = studentReference.get();
            DocumentSnapshot studentDocumentSnapshot = studentFuture.get();
            Student s = studentDocumentSnapshot.toObject(Student.class);
            json += mapper.writerWithDefaultPrettyPrinter().writeValueAsString(s);
            json += ",";
        }
        StringBuilder sb = new StringBuilder(json);
        sb.deleteCharAt(sb.length()-1);
        json = sb.toString();
        json += "]";
        return json;
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
