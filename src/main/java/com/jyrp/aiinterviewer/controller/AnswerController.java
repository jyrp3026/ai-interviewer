package com.jyrp.aiinterviewer.controller;

import com.jyrp.aiinterviewer.entity.Answer;
import com.jyrp.aiinterviewer.service.AnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AnswerController {

    private final AnswerService answerService;
    @PostMapping("/questions/{questionId}/answers")
    public Answer submit(@PathVariable Long questionId, @RequestParam String content){
        return answerService.submit(questionId, content);
    }

}
