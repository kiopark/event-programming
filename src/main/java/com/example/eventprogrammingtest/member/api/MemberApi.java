package com.example.eventprogrammingtest.member.api;

import com.example.eventprogrammingtest.member.application.MemberService;
import com.example.eventprogrammingtest.member.dto.MemberDto;
import com.example.eventprogrammingtest.member.dto.MemberRegisterInfoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberApi {

    private final MemberService memberService;

    @PostMapping("/register")
    public ResponseEntity<MemberRegisterInfoDto> registerMember(@RequestBody MemberDto requestDto) throws Exception {
        return ResponseEntity.ok().body(memberService.registerMember(requestDto));
    }
}
