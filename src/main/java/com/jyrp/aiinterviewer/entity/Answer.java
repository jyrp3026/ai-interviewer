package com.jyrp.aiinterviewer.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;
    @OneToOne
    private Question question;
    @Column(length = 2000)
    private String feedback;
    private LocalDateTime createdAt;

    public Answer(String content, Question question) {
        this.content = content;
        this.question = question;
        this.createdAt = LocalDateTime.now();
    }

    public void addFeedback(String feedback) {

        this.feedback = feedback;
    }


}
