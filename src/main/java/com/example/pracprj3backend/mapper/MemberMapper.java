package com.example.pracprj3backend.mapper;

import com.example.pracprj3backend.domain.Member;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Optional;

@Mapper
public interface MemberMapper {

    @Insert("""
            INSERT INTO member (userId, userPassword, userNickName, userEmail)
            VALUES (#{userId}, #{userPassword}, #{userNickName}, #{userEmail})
            """)
    int insert(Member member);

    Optional<Member> findByMemberId(String member);

    @Select("""
            SELECT userId
            FROM member
            WHERE userId = #{userId}
            """)
    boolean selectById(String userId);
}
