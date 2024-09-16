package com.aniket.polls.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aniket.polls.Service.AdminQuestionService;
import com.aniket.polls.model.CreateQuestionRequest;

@RestController
public class AdminQuestionController {

    private final AdminQuestionService questionService;

    public AdminQuestionController(AdminQuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping("/admin/create-question")
    public String createQuestion(@RequestBody CreateQuestionRequest request) {
        return questionService.createQuestion(request);
    }
}
