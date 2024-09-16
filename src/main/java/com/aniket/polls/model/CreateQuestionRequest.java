package com.aniket.polls.model;

import java.util.List;

import lombok.Data;

@Data
public class CreateQuestionRequest {
    private String id;
    private String question;
    private List<String> choices;

    // Getters and Setters
}
