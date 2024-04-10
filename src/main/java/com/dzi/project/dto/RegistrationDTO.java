package com.dzi.project.dto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class RegistrationDTO {
    @NotEmpty(message = "This field cannot be empty")
    private String username;

    @NotEmpty(message = "This field cannot be empty")
    private String firstName;

    @NotEmpty(message = "This field cannot be empty")
    private String lastName;

    @NotEmpty(message = "This field cannot be empty")
    private String email;

    @NotEmpty(message = "This field cannot be empty")
    @Size(min = 5, message = "Password must be at least 5 characters long")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
