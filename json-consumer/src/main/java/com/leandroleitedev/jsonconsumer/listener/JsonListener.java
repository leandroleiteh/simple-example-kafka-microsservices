package com.leandroleitedev.jsonconsumer.listener;

import com.leandroleitedev.jsonconsumer.model.Payment;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import static java.lang.Thread.sleep;

@Component
@Slf4j
public class JsonListener {

    @SneakyThrows
    @KafkaListener(topics = "payment-topic", groupId = "create-group", containerFactory = "jsonKafkaListenerContainerFactory")
    public void antiFraud(@Payload Payment payment) {

        log.info("Payment receive ... {} ", payment.toString());
        sleep(1500);

        log.info("validating fraud ...");
        sleep(2000);

        log.info("approved purchase ...");
        sleep(3000);
    }

    @SneakyThrows
    @KafkaListener(topics = "payment-topic", groupId = "pdf-group", containerFactory = "jsonKafkaListenerContainerFactory")
    public void generatePdf(@Payload Payment payment) {
        sleep(5000);
        log.info("Generate PDF of ID ... {} ", payment.getId());

    }

    @SneakyThrows
    @KafkaListener(topics = "payment-topic", groupId = "email-group", containerFactory = "jsonKafkaListenerContainerFactory")
    public void sendEmail() {
        sleep(7000);
        log.info("send e-mail of confirmation ...");
    }
}
