package com.example.cedar_data.configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
    @Configuration
    @EnableWebMvc
    public class WebConfig implements WebMvcConfigurer {

        @Override
        // CORS configuration for front end
        public void addCorsMappings(CorsRegistry registry) {
            registry
                    .addMapping("/**")
                    .allowedOrigins("http://3.142.236.250", "http://ec2-3-142-236-250.us-east-2.compute.amazonaws.com")
                    .allowedMethods("*")
                    .allowedHeaders("*")
                    .allowCredentials(true);
        }

        @Bean
        public RestTemplate addRestTemplate() {
            RestTemplate restTemplate = new RestTemplate();
            return restTemplate;
        }

        @Bean
        public BCryptPasswordEncoder addBCryptPasswordEncoder() {
            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            return bCryptPasswordEncoder;
        }
    }

