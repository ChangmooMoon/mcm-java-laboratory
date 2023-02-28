package com.example.jdbc_example.dao;

import com.example.jdbc_example.spring.Member;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

public class MemberDao {

    private JdbcTemplate jdbcTemplate;

    public MemberDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Member selectByEmail(String email) {
        List<Member> results = jdbcTemplate.query(
            "select * from Member where EMAIL = ?",
            (rs, rowNum) -> {
                Member member = new Member(
                    rs.getString("EMAIL"),
                    rs.getString("PASSWORD"),
                    rs.getString("NAME"),
                    rs.getTimestamp("REGDATE").toLocalDateTime()
                );
                member.setId(rs.getLong("ID"));
                return member;
            },
            email
        );
        return results.isEmpty() ? null : results.get(0);
    }

    public void insert(Member member) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(final Connection con) throws SQLException {
                PreparedStatement pstmt = con.prepareStatement(
                    "insert into Member (EMAIL, PASSWORD, NAME, REGDATE)" + "values(?, ?, ?, ?)",
                    new String[]{"ID"}
                );

                pstmt.setString(1, member.getEmail());
                pstmt.setString(2, member.getPassword());
                pstmt.setString(3, member.getName());
                pstmt.setTimestamp(4, Timestamp.valueOf(member.getRegisterDateTime()));

                return pstmt;
            }
        }, keyHolder);

        Number keyValue = keyHolder.getKey();
        member.setId(keyValue.longValue());
    }

    public void update(Member member) {

    }

    public List<Member> selectAll() {
        return jdbcTemplate.query(
            "select * from Member",
            (ResultSet rs, int rowNum) -> {
                Member member = new Member(
                    rs.getString("EMAIL"),
                    rs.getString("PASSWORD"),
                    rs.getString("NAME"),
                    rs.getTimestamp("REGDATE").toLocalDateTime()
                );
                member.setId((rs.getLong("ID")));
                return member;
            }
        );
    }
}
