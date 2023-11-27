package com.example.pracprj3backend.service;

import com.example.pracprj3backend.domain.Member;
import com.example.pracprj3backend.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestAttributes;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final PasswordEncoder passwordEncoder;
    private final MemberMapper mapper;

    public boolean insert(Member member) {
        member.setUserPassword(passwordEncoder.encode(member.getUserPassword()));
        return mapper.insert(member) == 1;
    }

    public boolean login(Member member) {
        return mapper.selectById(member.getUserId());
    }
}
