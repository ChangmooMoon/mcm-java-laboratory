package com.example.di_without_spring.service;

import com.example.di_without_spring.config.exception.MemberNotFoundException;
import com.example.di_without_spring.model.Member;
import com.example.di_without_spring.repository.MemberDao;

public class ChangePasswordService {

    private MemberDao memberDao;

    public void changePassword(String email, String oldPassword, String newPassword) {
        Member member = memberDao.selectByEmail(email);
        if (member == null) {
            throw new MemberNotFoundException();
        }

        member.changePassword(oldPassword, newPassword);
        memberDao.update(member);
    }

    public void setMemberDao(MemberDao memberDao) {
        this.memberDao = memberDao;
    }
}
