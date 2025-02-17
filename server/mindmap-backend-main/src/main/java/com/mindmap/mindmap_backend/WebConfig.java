package com.mindmap.mindmap_backend;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedOrigins(
                    "http://localhost:5173",
                    "https://mind-map-rn.netlify.app",
                    "https://mindmap-htwn.onrender.com" // Frontend URL
                )
                .allowedMethods("*")
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}