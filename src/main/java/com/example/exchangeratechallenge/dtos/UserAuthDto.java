package com.example.exchangeratechallenge.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class UserAuthDto {

    private Integer id;

    @Email(message = "formato email no valido")
    @NotEmpty(message = "email no debe estar vacio")
    private String email;

    @NotEmpty(message = "password no debe estar vacio")
    @Size(min = 6, message = "password debe tener al menos 6 caracteres")
    private String password;

    @NotEmpty(message = "role no debe estar vacio")
    private String role;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
