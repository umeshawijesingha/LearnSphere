package com.learnsphere.learnsphere.controller;

import com.learnsphere.learnsphere.dto.PaymentRequest;
import com.learnsphere.learnsphere.dto.PaymentResponse;
import com.learnsphere.learnsphere.entity.Payment;
import com.learnsphere.learnsphere.mapper.PaymentMapper;
import com.learnsphere.learnsphere.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @Autowired
    private PaymentMapper paymentMapper;

    @GetMapping
    public ResponseEntity<List<PaymentResponse>> getAllPayments(){
        List<Payment> payments = paymentService.getAllPayments();
        List<PaymentResponse> responses = payments.stream()
                .map( payment -> paymentMapper.toResponse(payment)).toList();

        return ResponseEntity.ok(responses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentResponse> getPaymentById(@PathVariable Long id){
        Payment payment = paymentService.getPaymentById(id);

        return ResponseEntity.ok(paymentMapper.toResponse(payment));
    }

    @PostMapping
    public ResponseEntity<PaymentResponse> createPayment(@RequestBody PaymentRequest request){
        Payment payment = paymentMapper.toEntity(request);
        payment = paymentService.createPayment(payment);

        return ResponseEntity.status(HttpStatus.CREATED).body(paymentMapper.toResponse(payment));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PaymentResponse> updatePayment(@PathVariable Long id, @RequestBody PaymentRequest request){
        Payment payment = paymentMapper.toEntity(request);
        payment = paymentService.updatePayment(id, payment);

        return ResponseEntity.ok(paymentMapper.toResponse(payment));
    }
}
