package com.learnsphere.learnsphere.service;

import com.learnsphere.learnsphere.entity.Payment;
import com.learnsphere.learnsphere.exception.ResourceNotFoundException;
import com.learnsphere.learnsphere.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public List<Payment> getAllPayments(){
        return paymentRepository.findAll();
    }

    public Payment getPaymentById(Long id){
        return paymentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Payment not found with Id:" +id));
    }

    public Payment createPayment(Payment payment){
        return paymentRepository.save(payment);
    }

    public Payment updatePayment(Long id, Payment payment){
        Payment existingPayment = paymentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Payment not found with Id:" +id));

        existingPayment.setStatus(payment.getStatus());
        existingPayment.setUpdateAt(payment.getUpdateAt());

        return paymentRepository.save(existingPayment);
    }
}
