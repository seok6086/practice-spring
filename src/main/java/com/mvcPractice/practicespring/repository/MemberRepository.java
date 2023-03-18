package com.mvcPractice.practicespring.repository;

import com.mvcPractice.practicespring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id); //null일 경우를 예상하여 optional
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
