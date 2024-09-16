package com.aniket.polls.Service;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.aniket.polls.model.SubmitAnswerRequest;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserAnswerService {

    private final KafkaTemplate<String, SubmitAnswerRequest> kafkaTemplate;

    public UserAnswerService(KafkaTemplate<String, SubmitAnswerRequest> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public String submitAnswer(SubmitAnswerRequest request) {
        kafkaTemplate.send("user_answers_topic", request);
        return "Answer submitted successfully!";
    }
}



