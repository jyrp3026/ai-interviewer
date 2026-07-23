package com.jyrp.aiinterviewer.service;

import com.jyrp.aiinterviewer.entity.InterviewSession;
import com.jyrp.aiinterviewer.entity.Member;
import com.jyrp.aiinterviewer.repository.InterviewSessionRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InterviewSessionService {

    private final InterviewSessionRepository interviewSessionRepository;

    public InterviewSession start(String jobPosition) {
        InterviewSession interviewSession = new InterviewSession(jobPosition);
        return interviewSessionRepository.save(interviewSession);

    }
    public InterviewSession end(Long sessionId) {
        InterviewSession session = interviewSessionRepository.findById(sessionId)
                .orElseThrow();
        session.end();
        return interviewSessionRepository.save(session);
    }
}
