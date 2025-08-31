package com.example.cedar_data.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="user")
public class User {

    //primary key
    @Id
    private String einNumber;
    private String firstName;
    private String lastName;
    private String password;

    public User() {

    }

    public User(String einNumber, String firstName, String lastName, String password) {
        this.einNumber = einNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }

    public String getEinNumber() {
        return einNumber;
    }

    public void setEinNumber(String einNumber) {
        this.einNumber = einNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
