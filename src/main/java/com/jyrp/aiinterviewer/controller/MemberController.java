package com.jyrp.aiinterviewer.controller;

import com.jyrp.aiinterviewer.entity.Member;
import com.jyrp.aiinterviewer.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;   // 접수원은 주방장(Service)을 연결

    @PostMapping("/members")
    public Member join(@RequestParam String email,
                       @RequestParam String nickname) {
        return memberService.join(email, nickname);
    }
}