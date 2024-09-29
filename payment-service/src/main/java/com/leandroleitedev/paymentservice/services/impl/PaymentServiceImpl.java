package com.leandroleitedev.paymentservice.services.impl;

import com.leandroleitedev.paymentservice.model.Payment;
import com.leandroleitedev.paymentservice.services.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PaymentServiceImpl implements PaymentService {

    @Override
    public void payment(Payment payment) {
        log.info(" PAYMENT_SERVICE_IMPL ::: Payment sent: {}", payment);
    }
}
