package com.example;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;

@SpringBootApplication
public class FilosSpringbootFirebaseApplication {

	public static void main(String[] args) throws IOException {
//		ClassLoader classLoader = FilosSpringbootFirebaseApplication.class.getClassLoader();
//
//		File file = new File(Objects.requireNonNull(classLoader.getResource("serviceAccountKey.json")).getFile());
//		FileInputStream serviceAccount = new FileInputStream(file.getAbsolutePath());
		FileInputStream serviceAccount = new FileInputStream("serviceAccountKey.json");

		FirebaseOptions options = new FirebaseOptions.Builder()
				.setCredentials(GoogleCredentials.fromStream(serviceAccount))
				.setDatabaseUrl("https://group-project-a8653-default-rtdb.firebaseio.com")
				.build();
		FirebaseApp.initializeApp(options);

		SpringApplication.run(FilosSpringbootFirebaseApplication.class, args);
	}

}
