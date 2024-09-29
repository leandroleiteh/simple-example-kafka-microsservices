package com.leandroleitedev.paymentservice.controller.impl;

import com.leandroleitedev.paymentservice.controller.PaymentController;
import com.leandroleitedev.paymentservice.model.Payment;
import com.leandroleitedev.paymentservice.services.impl.PaymentServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/payments")
public class PaymentControllerImpl implements PaymentController {

    private final PaymentServiceImpl paymentService;

    @Override
    public ResponseEntity<Payment> sendPayment(Payment payment) {
        paymentService.payment(payment);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
