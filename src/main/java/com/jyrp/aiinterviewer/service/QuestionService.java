package com.jyrp.aiinterviewer.service;

import com.jyrp.aiinterviewer.entity.InterviewSession;
import com.jyrp.aiinterviewer.entity.Question;
import com.jyrp.aiinterviewer.repository.InterviewSessionRepository;
import com.jyrp.aiinterviewer.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionRepository questionRepository;
    private final InterviewSessionRepository interviewSessionRepository;
    private final ClaudeService claudeService;

    public Question create(Long sessionId) {
        InterviewSession session = interviewSessionRepository.findById(sessionId)
                .orElseThrow();
        String prompt = session.getJobPosition() + " 직무 면접 질문을 1개 만들어줘. 질문만 출력하고 다른 말은 하지 마.";

        String questionText = claudeService.ask(prompt);
        
        Question question = new Question(questionText, session);
        return questionRepository.save(question);
    }
}