package com.mindmap.mindmap_backend;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MindmapBackendApplication {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(MindmapBackendApplication.class);
        app.setDefaultProperties(Collections.singletonMap("server.port", System.getenv("PORT")));
        app.run(args);
    }
}
