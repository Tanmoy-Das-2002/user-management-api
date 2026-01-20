package com.example.demo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UpdateUserRequest {
    
    @NotBlank(message = "Name cannot be empty")
    @Size(min=2, max = 50, message = "Name must be 2 to 50 charactars")
    private String name;

    @NotBlank(message = "Email cannot be empty")
    @Email(message = "Email must be valid")
    private String email;

    public UpdateUserRequest(){};

    public UpdateUserRequest (String name, String email) {
        this.name=name;
        this.email=email;
    }

    public String getName (){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    public String getEmail (){
        return email;
    }

    public void setEmail(String email){
        this.email=email;
    }
}
