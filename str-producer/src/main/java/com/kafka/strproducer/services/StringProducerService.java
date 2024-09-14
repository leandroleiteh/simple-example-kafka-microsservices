package com.kafka.strproducer.services;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Log4j2
@RequiredArgsConstructor
@Service
public class StringProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessageString(String message) {
       kafkaTemplate.send("str-topic", message)
        .whenComplete((result, ex) -> {
            if (ex == null) {
                log.info("Partition {}, offset {}", result.getRecordMetadata().partition(), result.getRecordMetadata().offset());
                log.info("Sent message with successfully {}", result.getProducerRecord().value());
            } else {
                log.error("Error sending message", ex);
            }

        });
    }
}
