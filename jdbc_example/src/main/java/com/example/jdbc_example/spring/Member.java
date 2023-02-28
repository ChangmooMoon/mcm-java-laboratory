package com.example.jdbc_example.spring;

import com.example.jdbc_example.exception.WrongIdPasswordException;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Member {

    private Long id;
    private String email;
    private String password;
    private String name;
    private LocalDateTime registerDateTime;

    public Member(String email, String password,
        String name, LocalDateTime regDateTime) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.registerDateTime = regDateTime;
    }

    public void changePassword(String oldPw, String newPw) {
        if (!password.equals(oldPw)) {
            throw new WrongIdPasswordException();
        }
        this.password = newPw;
    }
}
