package com.example.eventprogrammingtest.member.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity(name = "MEMBER_LOG")
public class MemberLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_log_id")
    private Long memberLogId;

    private String description;

    @Builder
    public MemberLog(Long memberLogId, String description) {
        this.memberLogId = memberLogId;
        this.description = description;
    }
}
