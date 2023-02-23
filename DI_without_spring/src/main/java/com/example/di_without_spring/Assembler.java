package com.example.di_without_spring;

import com.example.di_without_spring.repository.MemberDao;
import com.example.di_without_spring.service.ChangePasswordService;
import com.example.di_without_spring.service.MemberRegiesterService;
import lombok.Getter;

@Getter
public class Assembler {

    private MemberDao memberDao;

    private MemberRegiesterService memberRegiesterService;

    private ChangePasswordService changePasswordService;

    public Assembler() {
        memberDao = new MemberDao();
        memberRegiesterService = new MemberRegiesterService(memberDao);
        changePasswordService = new ChangePasswordService();
        changePasswordService.setMemberDao(memberDao);
    }


}
