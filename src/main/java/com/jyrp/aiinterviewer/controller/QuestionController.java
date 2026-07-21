package com.jyrp.aiinterviewer.controller;

import com.jyrp.aiinterviewer.entity.Question;
import com.jyrp.aiinterviewer.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class QuestionController {
    private final QuestionService questionService;

    @PostMapping("/sessions/{sessionId}/questions")
    public Question create(@PathVariable Long sessionId) {
    return questionService.create(sessionId);
    }

}
