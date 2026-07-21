package com.jyrp.aiinterviewer.repository;

import com.jyrp.aiinterviewer.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
}
