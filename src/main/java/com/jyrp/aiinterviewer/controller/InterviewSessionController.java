package com.jyrp.aiinterviewer.controller;

import com.jyrp.aiinterviewer.entity.InterviewSession;
import com.jyrp.aiinterviewer.service.InterviewSessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class InterviewSessionController {

    private final InterviewSessionService interviewSessionService;

    @PostMapping("/sessions")
    public InterviewSession start(@RequestParam String jobPosition){
        return interviewSessionService.start(jobPosition);
    }
}
