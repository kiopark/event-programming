package com.example.eventprogrammingtest.member.application.event;

import com.example.eventprogrammingtest.member.repository.MemberLogRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Slf4j
@Component
@RequiredArgsConstructor
public class MemberEventListener {

    private final MemberLogRepository memberLogRepository;

    @Async
//    @EventListener
    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
    public void userLogRegisteredEvent(final MemberLogRegisteredEvent event) throws Exception {
        long currentThread = Thread.currentThread().getId();
        log.info("[{}] --------> (이벤트) 로그 등록 START!", currentThread);

        memberLogRepository.save(event.toEntity(currentThread));
        if ( true ) throw new RuntimeException("이미 존재하는 회원입니다.");

        log.info("[{}] --------> (이벤트) 로그 등록 END!", currentThread);
    }

}
