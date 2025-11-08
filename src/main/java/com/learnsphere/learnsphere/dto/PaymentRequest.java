package com.learnsphere.learnsphere.dto;

import com.learnsphere.learnsphere.entity.Course;
import com.learnsphere.learnsphere.entity.Student;
import com.learnsphere.learnsphere.enums.PaymentStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentRequest {
    private Double amount;
    private String paymentMethod;
    private String transactionId;
    private PaymentStatus status;
    private Course course;
    private Student student;
}
