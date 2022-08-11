package com.example.eventprogrammingtest.member.application.event;

import com.example.eventprogrammingtest.member.domain.MemberLog;
import lombok.Builder;
import lombok.Getter;

@Getter
public class MemberLogRegisteredEvent {

    private String memberName;

    @Builder
    public MemberLogRegisteredEvent(String memberName) {
        this.memberName = memberName;
    }

    public MemberLog toEntity(long currentThread) {
        return MemberLog.builder()
                .description(String.valueOf(currentThread))
                .build();
    }

}
