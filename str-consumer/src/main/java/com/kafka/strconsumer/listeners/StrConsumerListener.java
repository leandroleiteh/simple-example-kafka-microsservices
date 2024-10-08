package com.kafka.strconsumer.listeners;

import com.kafka.strconsumer.custom.StrCustomKafkaListenerAnottation;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class StrConsumerListener {


    /* Quatro diferentes formas de indicar um ouvinte. */

    @StrCustomKafkaListenerAnottation(groupId = "group-2")
    public void createFlow(String message) {
        log.info("CREATE FLOW ::: Receive message {}", message);
    }

    @KafkaListener(groupId = "group-2", topicPartitions = {@TopicPartition(topic = "str-topic", partitions = {"1"}),},
            containerFactory = "strContainerFactory")
    public void createApproved(String message, Acknowledgment ack) {
        try {
            log.info("CREATE APPROVED ::: Receive message {}", message);
             ack.acknowledge();
        } catch (Exception e) {
            log.error(e);
        }
    }

    @SneakyThrows
    @KafkaListener(groupId = "group-1", topics = "str-topic", containerFactory = "strContainerFactory", errorHandler = "errorCustomHandler")
    public void createHistorical(String message) {
        log.info("CREATE HISTORICAL ::: Receive message {}", message);
        throw new IllegalArgumentException("Exceção forçada para que o errorHandler do kafka capture e trate");
    }

    @KafkaListener(groupId = "group-3", topics = "str-topic", containerFactory = "strContainerFactoryValidMessage")
    public void createInfo(String message) {
        log.info("CREATE INFO ::: Receive message {}", message);
    }

}
