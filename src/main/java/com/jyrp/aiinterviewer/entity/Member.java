package com.jyrp.aiinterviewer.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity         // 1. 테이블 선언
@Getter
@NoArgsConstructor
public class Member {

    @Id      // 2. PK
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // 3. 자동 증가
    private Long id;

    private String email;
    private String nickname;

    private LocalDateTime createdAt;
}