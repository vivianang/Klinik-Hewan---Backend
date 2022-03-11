package com.project.AppKlinik.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration {
  @Bean
  public WebMvcConfigurer corsConfigurer() {
    return new WebMvcConfigurer() {
      @Override
      public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://10.61.38.12:8080", "http://localhost:8080","http://10.61.50.124:8080","http://10.21.112.28:8081", "http://localhost:8081","http://10.61.39.7:8080","http://172.26.93.199:8080","http://10.21.112.186:8080")
                .allowedMethods("GET","POST","PUT","DELETE","OPTIONS")
                .allowedHeaders("X-Requested-With", "Origin", "Content-Type", "Accept",
                        "Authorization", "Access-Control-Allow-Credentials", "Access-Control-Allow-Headers", "Access-Control-Allow-Methods",
                        "Access-Control-Allow-Origin", "Access-Control-Expose-Headers", "Access-Control-Max-Age",
                        "Access-Control-Request-Headers", "Access-Control-Request-Method", "Age", "Allow", "Alternates",
                        "Content-Range", "Content-Disposition", "Content-Description")
                .maxAge(3600);
      }
    };
  }
}