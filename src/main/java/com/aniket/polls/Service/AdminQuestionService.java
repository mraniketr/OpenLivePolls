package com.aniket.polls.Service;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import com.aniket.polls.model.CreateQuestionRequest;

@Service
public class AdminQuestionService {

    private final StringRedisTemplate redisTemplate;

    public AdminQuestionService(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public String createQuestion(CreateQuestionRequest request) {
        String questionId = request.getId();
        String questionText = request.getQuestion();
        String choices = String.join(",", request.getChoices());

        redisTemplate.opsForHash().put("question_" + questionId, "question", questionText);
        redisTemplate.opsForHash().put("question_" + questionId, "choices", choices);
        
        return "Question created successfully!";
    }
}
