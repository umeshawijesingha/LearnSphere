package com.learnsphere.learnsphere.dto;

import com.learnsphere.learnsphere.enums.StudentStatus;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class StudentRequest {

    @NotBlank(message = "First name is required")
    @Pattern(regexp = ".*[A-Za-z]].*", message = "First letter must contain at least one letter")
    private String firstname;

    private String lastName;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    private String address;
    private String city;
    private String school;

    @NotBlank(message = "Contact number is required")
    @Pattern(regexp = "^(?:\\\\+94|0)?7\\\\d{8}$")
    private String contactNo;

    private String nicUrl;
    private String profileUrl;
    private Date dateOfBirth;
    private StudentStatus status;
}
