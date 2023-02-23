package com.example.di_without_spring.model;

import com.example.di_without_spring.config.exception.WrongIdPasswordException;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@EqualsAndHashCode(of = {"id", "email"})
public class Member {

    private Long id;

    private String email;

    private String password;

    private String name;

    private LocalDateTime registerDateTime;

    public void changePassword(String oldPassword, String newPassword) {
        if (!password.equals(oldPassword)) {
            throw new WrongIdPasswordException();
        }
        this.password = newPassword;
    }
}
