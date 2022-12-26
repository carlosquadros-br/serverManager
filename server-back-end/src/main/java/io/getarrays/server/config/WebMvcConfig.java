package io.getarrays.server.config;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET", "POST", "PUT", "OPTIONS", "DELETE", "PATCH")
                .allowedHeaders("Origin", "Content-Type", "Accept", "Jwt-Token", "Authorization", "Access-Control", "Access-Control-Allow-Origin")
                .allowCredentials(true);
    }

}
