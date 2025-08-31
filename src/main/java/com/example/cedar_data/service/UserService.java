package com.example.cedar_data.service;
import com.example.cedar_data.dto.LoginResponseDto;
import com.example.cedar_data.dto.SignUpDto;
import com.example.cedar_data.dto.UserDto;
import com.example.cedar_data.model.User;
import io.jsonwebtoken.Jwts;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.cedar_data.repository.UserRepository;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public UserDto getAccountInfo(String einNumber) {
        User user = userRepository.findByEinNumber(einNumber).orElseThrow(() -> new RuntimeException("EIN " + einNumber + " not found"));

        return mapToAccount(user);
    }

    public SignUpDto signUpUser(SignUpDto signUpDto) {

        User user = new User();

        if(userRepository.findByEinNumber(signUpDto.getEinNumber()).isPresent()) {
            throw new RuntimeException("EIN Number already in use!");
        }

        user.setEinNumber(signUpDto.getEinNumber());
        user.setFirstName(signUpDto.getFirstName());
        user.setLastName(signUpDto.getLastName());
        String plainPassword = signUpDto.getPassword();
        String encryptedPassword = bCryptPasswordEncoder.encode(plainPassword);
        user.setPassword(encryptedPassword);

        User savedUser = userRepository.save(user);
        SignUpDto dto = mapToUser(savedUser);
        return dto;
    }

    public LoginResponseDto loginUser(String einNumber, String password) {
        // Fetch the user from the database using the EIN number
        User user = userRepository.findByEinNumber(einNumber).orElseThrow(() -> new RuntimeException("EIN not found"));
        // If the password does not match the stored hash, throw an exception
        if(!bCryptPasswordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Password does not match");
        }
        // Generate a secret key for signing the JWT
        SecretKey key = Jwts.SIG.HS256.key().build();
        // Build the JWT token
        String jwt = Jwts.builder()
                .subject(user.getEinNumber())
                .claim("firstName", user.getFirstName())
                .claim("lastName", user.getLastName())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 86400000)) // 24 Hours
                .signWith(key)
                .compact();
        // return to the client
        LoginResponseDto dto = mapLogin(user, jwt);
        return dto;
    }

    private UserDto mapToAccount(User user) {
        UserDto userDto = new UserDto();

        userDto.setEinNumber(user.getEinNumber());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());

        return userDto;
    }

    private SignUpDto mapToUser(User user) {
        SignUpDto signUpDto = new SignUpDto();

        signUpDto.setEinNumber(user.getEinNumber());
        signUpDto.setFirstName(user.getFirstName());
        signUpDto.setLastName(user.getLastName());
        signUpDto.setPassword(user.getPassword());

        return signUpDto;
    }

    private LoginResponseDto mapLogin(User user, String jwt) {
        LoginResponseDto loginResponseDto = new LoginResponseDto();

        loginResponseDto.setEinNumber(user.getEinNumber());
        loginResponseDto.setFirstName(user.getFirstName());
        loginResponseDto.setLastName(user.getLastName());
        loginResponseDto.setJwtToken(jwt);
        return loginResponseDto;
    }

}
