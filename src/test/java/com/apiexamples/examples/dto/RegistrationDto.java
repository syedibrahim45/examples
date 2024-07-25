package com.apiexamples.examples.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class RegistrationDto {

    private Long id;


    @Size(min = 2, max =20, message = "should be 2 more characters")
    private String name;

    @Email(message = "Invalid email format")
    private String email;

    @Size(min = 10, max =15, message = "should be 10 or more digits")
    private String mobile;

    private String message;



}