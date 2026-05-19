package com.example.app.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "API de Gestión de Soporte Técnico",
                version = "1.0.0",
                description = "Documentación interactiva de los endpoints para el sistema de registro de clientes, equipos y notas de diagnóstico.",
                contact = @Contact(
                        name = "Tu Nombre",
                        email = "tu.email@ejemplo.com"
                )
        )
)
public class SwaggerConfig {
    // La configuración se maneja completamente a través de las anotaciones
}
