package com.example.jwt.domain.member.controller;

import com.example.jwt.domain.member.entity.Member;
import jakarta.validation.Valid;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;

    @Data
    public static class LoginRequest {
        @NotBlank
        private String username;

        @NotBlank
        private String password;
    }

    @PostMapping("/login")
    public Member login(@Valid @RequestBody LoginRequest loginRequest) {
        return memberService.findByUsername(loginRequest.getUsername()).orElse(null);
    }
}