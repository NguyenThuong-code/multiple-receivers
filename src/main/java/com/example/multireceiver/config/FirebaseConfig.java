package com.example.multireceiver.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.FirebaseMessaging;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

@Configuration
@RequiredArgsConstructor
public class FirebaseConfig {
    private final FirebaseProperties firebaseProperties;

    @Bean
    FirebaseMessaging firebaseMessaging() throws IOException {
        GoogleCredentials googleCredentials = GoogleCredentials
                .fromStream(new ClassPathResource("test-config-82c56-firebase-adminsdk-gyaqd-a89616407e.json").getInputStream());
        FirebaseOptions firebaseOptions = FirebaseOptions
                .builder()
                .setCredentials(googleCredentials)
                .build();
        FirebaseApp app= FirebaseApp.initializeApp(firebaseOptions); // Initialize without specifying a name
        return FirebaseMessaging.getInstance(app); // Use the default FirebaseApp
    }
}
