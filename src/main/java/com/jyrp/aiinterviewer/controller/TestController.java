package com.jyrp.aiinterviewer.controller;

import com.jyrp.aiinterviewer.service.ClaudeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final ClaudeService claudeService;

    @PostMapping("/test/claude")
    public String askClaude(@RequestParam String prompt){
        return claudeService.ask(prompt);
    }

}
