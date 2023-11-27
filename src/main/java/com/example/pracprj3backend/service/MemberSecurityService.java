package com.example.pracprj3backend.service;


import com.example.pracprj3backend.domain.Member;
import com.example.pracprj3backend.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberSecurityService implements UserDetailsService {

    private final MemberMapper memberMapper;

    @Override
    public UserDetails loadUserByUsername(String member) throws UsernameNotFoundException {
        Optional<Member> _member = memberMapper.findByMemberId(member);
        if(_member.isEmpty()){
            throw new UsernameNotFoundException("없음");
        }
        Member foundmember = _member.get();
        List<GrantedAuthority> authorities = new ArrayList<>();
        return new User(foundmember.getUserId(),
                foundmember.getUserPassword(),
                authorities);
    }
}

