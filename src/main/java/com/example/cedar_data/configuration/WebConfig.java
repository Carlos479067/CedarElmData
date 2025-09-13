package com.example.cedar_data.configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
    @Configuration
    @EnableWebMvc
    public class WebConfig implements WebMvcConfigurer {

//        @Value("${frontend_url}")
//        private String frontendUrl;

        @Override
        // CORS configuration for front end
        public void addCorsMappings(CorsRegistry registry) {
            registry
                    .addMapping("/api/**")
                    .allowedOrigins("https://clinquant-zabaione-2d7570.netlify.app/")
                    .allowedMethods("*")
                    .allowedHeaders("*")
                    .allowCredentials(true);
        }

        @Bean
        public RestTemplate addRestTemplate() {
            RestTemplate restTemplate = new RestTemplate();
            return restTemplate;
        }

//        @Bean
//        public BCryptPasswordEncoder addBCryptPasswordEncoder() {
//            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//            return bCryptPasswordEncoder;
//        }
    }

