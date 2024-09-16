package com.aniket.polls.controller;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserEventProducerController {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public UserEventProducerController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping("/events")
    public String produceUserEvent(@RequestParam String event) {
        kafkaTemplate.send("user_events_topic", event);
        return "User event sent to Kafka successfully!";
    }
}
