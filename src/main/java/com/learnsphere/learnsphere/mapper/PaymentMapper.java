package com.learnsphere.learnsphere.mapper;

import com.learnsphere.learnsphere.dto.PaymentRequest;
import com.learnsphere.learnsphere.dto.PaymentResponse;
import com.learnsphere.learnsphere.entity.Payment;
import org.springframework.stereotype.Component;

@Component
public class PaymentMapper implements Mapper <Payment, PaymentRequest, PaymentResponse>{
    @Override
    public Payment toEntity(PaymentRequest request) {
        Payment payment = new Payment();
        payment.setAmount(request.getAmount());
        payment.setPaymentMethod(request.getPaymentMethod());
        payment.setTransactionId(request.getTransactionId());
        payment.setStatus(request.getStatus());
        payment.setStudent(request.getStudent());
        payment.setCourse(request.getCourse());
        return payment;
    }

    @Override
    public PaymentResponse toResponse(Payment payment) {
        PaymentResponse response = new PaymentResponse();
        response.setId(payment.getId());
        response.setAmount(payment.getAmount());
        response.setPaymentMethod(payment.getPaymentMethod());
        response.setTransactionId(payment.getTransactionId());
        response.setStatus(payment.getStatus());
        response.setStudent(payment.getStudent());
        response.setCourse(payment.getCourse());
        response.setCreateAt(payment.getCreateAt());
        response.setUpdateAt(payment.getUpdateAt());
        return response;
    }
}
