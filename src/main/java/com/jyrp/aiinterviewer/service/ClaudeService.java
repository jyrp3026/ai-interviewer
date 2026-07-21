package com.jyrp.aiinterviewer.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.Map;

@Service
public class ClaudeService {

    private final RestClient restClient;

    public ClaudeService(@Value("${claude.api.key}") String apiKey) {
        this.restClient = RestClient.builder()
                .baseUrl("https://api.anthropic.com/v1/messages")
                .defaultHeader("x-api-key", apiKey)
                .defaultHeader("anthropic-version", "2023-06-01")
                .build();
    }

    public String ask(String prompt) {
        Map<String, Object> requestBody = Map.of(
                "model", "claude-haiku-4-5",
                "max_tokens", 1024,
                "messages", List.of(
                        Map.of("role", "user", "content", prompt)
                )
        );

        Map response = restClient.post()
                .contentType(MediaType.APPLICATION_JSON)
                .body(requestBody)
                .retrieve()
                .body(Map.class);

        List<Map<String, Object>> content = (List<Map<String, Object>>) response.get("content");
        return (String) content.get(0).get("text");
    }
}