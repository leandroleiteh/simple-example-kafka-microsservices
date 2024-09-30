package com.leandroleitedev.paymentservice.services.impl;

import com.leandroleitedev.paymentservice.model.Payment;
import com.leandroleitedev.paymentservice.services.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@RequiredArgsConstructor
@Service
@Slf4j
public class PaymentServiceImpl implements PaymentService {

    private final KafkaTemplate<String, Serializable> kafkaTemplate;

    @SneakyThrows
    @Override
    public void payment(Payment payment) {
        log.info("PAYMENT RECEIVE: {} ", payment);
        Thread.sleep(2000);

        log.info("PAYMENT SEND: {} ", payment);

        kafkaTemplate.send("payment-topic", payment);
    }
}
