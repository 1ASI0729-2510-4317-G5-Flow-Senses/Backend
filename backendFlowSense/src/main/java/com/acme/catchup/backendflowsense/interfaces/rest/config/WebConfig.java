package com.acme.catchup.backendflowsense.interfaces.rest.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/v1/**") // Apply CORS to all our API endpoints
                .allowedOrigins("http://localhost:4200", "http://localhost:3000", "http://localhost:5173", "https://frontend-web-application-five.vercel.app") // Allow frontend origins
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Allowed HTTP methods
                .allowedHeaders("*")
                .allowCredentials(true);
    }
} 