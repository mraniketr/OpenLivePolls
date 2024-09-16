package com.aniket.polls.Service;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.aniket.polls.model.SubmitAnswerRequest;

@Service
public class AnswerConsumerService {

    private final StringRedisTemplate redisTemplate;

    public AnswerConsumerService(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @KafkaListener(topics = "user_answers_topic", groupId = "answers_group")
    public void consumeAnswer(SubmitAnswerRequest request) {
        String questionId = request.getQuestionId();
        String answer = request.getAnswer();

        // Increment the count of the specific answer in Redis
        redisTemplate.opsForHash().increment("answers_" + questionId, answer, 1);
    }
}
