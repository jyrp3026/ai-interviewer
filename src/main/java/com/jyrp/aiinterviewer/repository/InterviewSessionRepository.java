package com.jyrp.aiinterviewer.repository;

import com.jyrp.aiinterviewer.entity.InterviewSession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterviewSessionRepository extends JpaRepository<InterviewSession, Long> {
}
