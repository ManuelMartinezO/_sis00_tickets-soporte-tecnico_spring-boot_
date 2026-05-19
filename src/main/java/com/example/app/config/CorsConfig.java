package com.example.app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(@NonNull CorsRegistry registry) {
        registry.addMapping("/api/**")
                // Permite cualquier dominio, puerto o protocolo
                .allowedOriginPatterns("*")
                // Métodos permitidos
                .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS")
                // Permite cualquier cabecera
                .allowedHeaders("*")
                // IMPORTANTE: Debe ser false si permites cualquier origen público
                .allowCredentials(false);
    }
}
