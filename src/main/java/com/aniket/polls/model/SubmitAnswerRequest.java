package com.aniket.polls.model;

import lombok.Data;

@Data
public class SubmitAnswerRequest {
    private String questionId;
    private String answer;

    // Getters and Setters
}
