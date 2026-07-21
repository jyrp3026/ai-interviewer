package com.jyrp.aiinterviewer.service;

import com.jyrp.aiinterviewer.entity.Member;
import com.jyrp.aiinterviewer.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Member join(String email, String nickname) {
        Member member = new Member(email, nickname);  
        return memberRepository.save(member);

    }
}