package com.jyrp.aiinterviewer.service;

import com.jyrp.aiinterviewer.entity.Answer;
import com.jyrp.aiinterviewer.entity.Question;
import com.jyrp.aiinterviewer.repository.AnswerRepository;
import com.jyrp.aiinterviewer.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AnswerService {

    private final AnswerRepository answerRepository;

    private final QuestionRepository questionRepository;

    private final ClaudeService claudeService;

    public Answer submit(Long questionId, String content) {
        Question question = questionRepository.findById(questionId).orElseThrow();

        String prompt = "면접 질문: " + question.getContent()
                + "\n지원자 답변: " + content
                + "\n위 답변을 평가하고 개선점을 3줄 이내로 피드백해줘.";

        String feedback = claudeService.ask(prompt);

        Answer answer = new Answer(content, question);
        answer.addFeedback(feedback);
        return answerRepository.save(answer);
    }


}
