package com.example.cedar_data.configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
        // Declare bean that configures security rules
        @Bean
        public SecurityFilterChain secureHttp(HttpSecurity http) throws Exception {
            http.csrf(AbstractHttpConfigurer::disable)
                    .authorizeHttpRequests((requests) -> requests
                    //No authorization needed for /signup & /account
                    .requestMatchers("/signup", "/account", "/login").permitAll()
                    .anyRequest().authenticated()
            );
            return http.build();
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



