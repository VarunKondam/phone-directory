package com.assignment.model;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

@Getter
@Setter
public class Contact {

    private Integer Id;
    @NotEmpty(message = "Please enter a valid name.")
    private String name;
    @NotEmpty(message = "Phone number cannot be empty.")
    //@Size(min = 1, message = "Phone number must be 10 digits")
    private String phoneNumber;
    @Email
    private String email;

}
