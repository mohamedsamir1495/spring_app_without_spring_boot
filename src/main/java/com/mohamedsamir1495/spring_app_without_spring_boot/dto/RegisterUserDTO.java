package com.mohamedsamir1495.spring_app_without_spring_boot.dto;

import lombok.Data;

@Data
public class RegisterUserDTO {
    String email;
    String name;

    public RegisterUserDTO(){

    }
    public RegisterUserDTO(String email, String name) {
        this.email = email;
        this.name = name;
    }
}
