package com.example.eventprogrammingtest.member.application;

import com.example.eventprogrammingtest.member.application.event.MemberLogRegisteredEvent;
import com.example.eventprogrammingtest.member.domain.Member;
import com.example.eventprogrammingtest.member.dto.MemberDto;
import com.example.eventprogrammingtest.member.dto.MemberRegisterInfoDto;
import com.example.eventprogrammingtest.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
@Slf4j
public class MemberService {

    private final ApplicationEventPublisher eventPublisher;
    private final MemberRepository memberRepository;

    @Transactional(rollbackOn = {Exception.class})
    public MemberRegisterInfoDto registerMember(MemberDto requestDto) throws Exception {
        long currentThread = Thread.currentThread().getId();
        log.info("[{}] --------> 유저 등록 START!", currentThread);

        checkMemberName(requestDto);

        Member memberInfo = memberRepository.save(requestDto.toEntity());

        eventPublisher.publishEvent(MemberLogRegisteredEvent.builder()
                         .memberName(requestDto.getMemberName())
                         .build());

        log.info("[{}] --------> 유저 등록 END!", currentThread);
        return MemberRegisterInfoDto.builder()
                        .memberId(memberInfo.getMemberId())
                        .memberName(memberInfo.getMemberName())
                        .build();
    }

    private void checkMemberName(MemberDto requestDto) throws Exception {
        boolean findMember = memberRepository.findByMemberName(requestDto.getMemberName())
                .isPresent();

        if (findMember) {
            throw new Exception("이미 존재하는 회원입니다.");
        }
    }
}
