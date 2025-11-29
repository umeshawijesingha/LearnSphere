package com.learnsphere.learnsphere.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SimpleStudentResponse {
    private Long id;
    private String firstname;
    private String lastName;
    private String email;
}
