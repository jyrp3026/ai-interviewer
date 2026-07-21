package com.jyrp.aiinterviewer.repository;

import com.jyrp.aiinterviewer.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
