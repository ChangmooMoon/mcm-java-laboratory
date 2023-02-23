package com.example.di_without_spring.service;

import com.example.di_without_spring.config.exception.DuplicateMemberException;
import com.example.di_without_spring.dto.RegisterDto;
import com.example.di_without_spring.model.Member;
import com.example.di_without_spring.repository.MemberDao;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MemberRegiesterService {

    private MemberDao memberDao;

    public long regist(RegisterDto request) {
        Member member = memberDao.selectByEmail(request.getEmail());
        if (member != null) {
            throw new DuplicateMemberException("dup email" + request.getEmail());
        }

        Member newMember = Member.builder()
            .email(request.getEmail())
            .password(request.getPassword())
            .name(request.getName())
            .registerDateTime(LocalDateTime.now())
            .build();

        memberDao.insert(newMember);
        return newMember.getId();
    }
}
