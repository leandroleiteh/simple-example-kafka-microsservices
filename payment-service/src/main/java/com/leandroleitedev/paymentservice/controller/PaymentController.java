package com.leandroleitedev.paymentservice.controller;

import com.leandroleitedev.paymentservice.model.Payment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface PaymentController {

    @PostMapping
    ResponseEntity<Payment> sendPayment(@RequestBody Payment payment);


}
