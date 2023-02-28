package com.example.jdbc_example;

import com.example.jdbc_example.config.AppConfig;
import com.example.jdbc_example.dao.MemberDao;
import com.example.jdbc_example.exception.MemberNotFoundException;
import com.example.jdbc_example.exception.WrongIdPasswordException;
import com.example.jdbc_example.spring.ChangePasswordService;
import com.example.jdbc_example.spring.Member;
import java.util.List;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JdbcExampleApplication {

    private static MemberDao memberDao;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        memberDao = ctx.getBean(MemberDao.class);
        selectAll();

        ChangePasswordService cps = ctx.getBean("changePassword", ChangePasswordService.class);

        try {
            cps.changePassword("mcm@mcm.com", "1234", "5678");
            System.out.println("암호 변경 완료");
        } catch (MemberNotFoundException e) {
            System.out.println("해당 멤버가 존재하지 않음");
        } catch (WrongIdPasswordException e) {
            System.out.println("암호가 올바르지 않음");
        }
        ctx.close();
    }

    private static void selectAll() {
        List<Member> members = memberDao.selectAll();
        for (Member m : members) {
            System.out.println(m.getId() + " " + m.getEmail() + " " + m.getName());
        }
    }

}
