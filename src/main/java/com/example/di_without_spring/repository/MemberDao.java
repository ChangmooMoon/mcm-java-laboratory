package com.example.di_without_spring.repository;

import com.example.di_without_spring.model.Member;
import java.util.HashMap;
import java.util.Map;
import lombok.Getter;

@Getter
public class MemberDao {

    public static long nextId = 1;

    public Map<String, Member> map = new HashMap<>();

    public Member selectByEmail(String email) {
        return map.get(email);
    }

    public void insert(Member member) {
        member.setId(++nextId);
        map.put(member.getEmail(), member);
    }

    public void update(Member member) {
        map.put(member.getEmail(), member);
    }

}
