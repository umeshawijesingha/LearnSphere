package com.learnsphere.learnsphere.dto;

import com.learnsphere.learnsphere.entity.Course;
import com.learnsphere.learnsphere.entity.Student;
import com.learnsphere.learnsphere.enums.PaymentStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PaymentResponse {
    private Long id;
    private Double amount;
    private String paymentMethod;
    private String transactionId;
    private PaymentStatus status;
    private Course course;
    private Student student;
    private Date createAt;
    private Date updateAt;
}
