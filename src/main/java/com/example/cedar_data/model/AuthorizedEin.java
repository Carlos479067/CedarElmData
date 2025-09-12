package com.example.cedar_data.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "authorized_ein")
public class AuthorizedEin {

    @Id
    @Column(name = "authorized_ein")
    private String authorizedEin;

    public AuthorizedEin() {

    }

    public AuthorizedEin(String authorizedEin) {
        this.authorizedEin = authorizedEin;
    }

    public String getAuthorizedEin() {
        return authorizedEin;
    }

    public void setAuthorizedEin(String authorizedEin) {
        this.authorizedEin = authorizedEin;
    }
}
