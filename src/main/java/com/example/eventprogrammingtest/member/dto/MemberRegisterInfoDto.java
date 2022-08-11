package com.example.eventprogrammingtest.member.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class MemberRegisterInfoDto {

    private Long memberId;

    private String memberName;

    @Builder
    public MemberRegisterInfoDto(Long memberId, String memberName) {
        this.memberId = memberId;
        this.memberName = memberName;
    }
}
