package com.example.cedar_data.configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.rmi.registry.Registry;
import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
        // Declare bean that configures security rules
        @Bean
        public SecurityFilterChain secureHttp(HttpSecurity http) throws Exception {
            http.csrf(csrf -> csrf.disable())
                    .authorizeHttpRequests((requests) -> requests
                    //No authorization needed for /signup & /account
                    .requestMatchers("/api/login", "/api/signup", "/api/results/**", "/api/codes/**").permitAll()
                    .anyRequest().authenticated()
            );
            return http.build();
        }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(List.of("http://3.142.236.250", "http://localhost:3000", "http://127.0.0.1:3000")); // your React dev server
        configuration.setAllowedMethods(List.of("GET","POST","PUT","DELETE","OPTIONS"));
        configuration.setAllowedHeaders(List.of("*"));
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    //Sets up an in-memory single user for testing
        @Bean
        public UserDetailsService userDetailsService() {
            PasswordEncoder encoder = new BCryptPasswordEncoder();
            UserDetails user = User.builder()
                    .username("user")
                    .password(encoder.encode("password"))
                    .roles("USER")
                    .build();

            return new InMemoryUserDetailsManager(user);
        }
}



