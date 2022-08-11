package com.example.eventprogrammingtest.member.dto;

import com.example.eventprogrammingtest.member.domain.Member;
import lombok.Getter;

@Getter
public class MemberDto {

    private String memberName;

    public Member toEntity() {
        return Member.builder()
                .memberName(this.memberName)
                .build();
    }
}
