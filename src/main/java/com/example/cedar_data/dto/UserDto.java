package com.example.cedar_data.dto;

public class UserDto {

    private String einNumber;
    private String firstName;
    private String lastName;

    public UserDto() {

    }

    public UserDto(String einNumber, String firstName, String lastName) {
        this.einNumber = einNumber;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getEinNumber() {
        return einNumber;
    }

    public void setEinNumber(String einNumber) {
        this.einNumber = einNumber;
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
