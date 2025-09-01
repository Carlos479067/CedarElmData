package com.example.cedar_data.dto;
// Class is used for when server sends information the client needs after authentication
public class LoginResponseDto {

    private String einNumber;
    private String firstName;
    private String lastName;
    private String jwtToken;

    public LoginResponseDto() {

    }

    public LoginResponseDto(String einNumber, String firstName, String lastName, String jwtToken) {
        this.einNumber = einNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.jwtToken = jwtToken;
    }

    public String getEinNumber() {
        return einNumber;
    }

    public void setEinNumber(String einNumber) {
        this.einNumber = einNumber;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
