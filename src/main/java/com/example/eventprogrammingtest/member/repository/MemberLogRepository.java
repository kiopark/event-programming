package com.example.eventprogrammingtest.member.repository;

import com.example.eventprogrammingtest.member.domain.MemberLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberLogRepository extends JpaRepository<MemberLog, Long> {
}
