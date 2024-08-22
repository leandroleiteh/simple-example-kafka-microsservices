package com.kafka.strproducer.controllers;

import com.kafka.strproducer.services.StringProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping("/producer")
public class StringProducerController {

    private final StringProducerService producerService;

    @PostMapping
    public ResponseEntity<?> SendMessageString(@RequestBody String message) {
        producerService.sendMessageString(message);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
