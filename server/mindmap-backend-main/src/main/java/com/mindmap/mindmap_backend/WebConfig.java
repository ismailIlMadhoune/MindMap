package com.mindmap.mindmap_backend;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**") // Apply CORS to all endpoints under "/api/**"
                .allowedOrigins(
                    "http://localhost:5173",    // Localhost URL (for local testing)
                    "https://mind-map-rn.netlify.app", // Deployed frontend URL
                    "https://mindmap-htwn.onrender.com" // Deployed backend URL (not required for CORS)
                )
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Include OPTIONS for preflight requests
                .allowedHeaders("*") // Allow all headers
                .exposedHeaders("Authorization") // Optional: expose specific headers to frontend if needed
                .allowCredentials(true); // Allow cookies or authentication headers
    }
}