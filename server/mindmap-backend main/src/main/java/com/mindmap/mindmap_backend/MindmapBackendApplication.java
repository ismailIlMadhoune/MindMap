package com.mindmap.mindmap_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MindmapBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(MindmapBackendApplication.class, args);
    }

    // Define RestTemplate Bean
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
