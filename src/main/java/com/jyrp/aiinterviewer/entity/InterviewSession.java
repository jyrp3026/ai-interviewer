package com.jyrp.aiinterviewer.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class InterviewSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String jobPosition;
    private String status;
    private LocalDateTime createdAt;

    public InterviewSession(String jobPosition) {
        this.jobPosition = jobPosition;
        this.status = "IN_PROGRESS";
        this.createdAt = LocalDateTime.now();
    }
    public void end() {
        this.status = "DONE";
    }

}
