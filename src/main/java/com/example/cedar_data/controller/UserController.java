package com.example.cedar_data.controller;
import com.example.cedar_data.dto.UserDto;
import org.springframework.web.bind.annotation.*;
import com.example.cedar_data.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {

        this.userService = userService;
    }

    @GetMapping("/account")
    //Spring stores current user as authentication object
    public UserDto getUserAccount(@RequestParam String einNumber) {
        return userService.getAccountInfo(einNumber);
    }
//
//    @PostMapping("/signup")
//    public SignUpDto createUserAccount(@RequestBody SignUpDto signUpDto) {
//        return userService.signUpUser(signUpDto);
//    }
//
//    @PostMapping("/login")
//    public LoginResponseDto loginUser(@RequestBody LoginDto loginDto) {
//        return userService.loginUser(loginDto.getEinNumber(), loginDto.getPassword());
//    }

}
