package br.com.software.contatos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {
    
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                // Habilita CORS para todos os endpoints
                registry.addMapping("/**")
                        // Permite requisições vindas do Angular em http://localhost:4200
                        .allowedOrigins("http://localhost:4200")
                        // Métodos HTTP permitidos
                        .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS")
                        // Cabeçalhos permitidos
                        .allowedHeaders("*");
            }
        };
    }
}
