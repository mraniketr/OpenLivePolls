package com.aniket.polls.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aniket.polls.Service.UserAnswerService;
import com.aniket.polls.model.SubmitAnswerRequest;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class UserAnswerController {

    private final UserAnswerService answerService;

    public UserAnswerController(UserAnswerService answerService) {
        this.answerService = answerService;
    }

    @PostMapping("/user/submit-answer")
    public String submitAnswer(@RequestBody SubmitAnswerRequest request) {
        return answerService.submitAnswer(request);
    }
}

