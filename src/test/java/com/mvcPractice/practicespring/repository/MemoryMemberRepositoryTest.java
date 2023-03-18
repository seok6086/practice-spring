package com.mvcPractice.practicespring.repository;

import com.mvcPractice.practicespring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();
    //testCode 부터 작성해서 개발을 진행하는 경우를 테스트 주도 개발 TDD
    @AfterEach
    public void afterEach() {
        //각 메서드가 동작이 끝날 때마다 레포지토리를 클리어 해주는 것

        repository.clearStore();
    }
    @Test
    public void save() {
        Member member = new Member();
        member.setName("Spring");

        repository.save(member);
        Member result = repository.findById(member.getId()).get();
        assertThat(member).isEqualTo(result); //일치하는지 확인
    }
    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("Spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("Spring2");
        repository.save(member2);

       Member result =  repository.findByName("Spring1").get();
       assertThat(result).isEqualTo(member1);
    }
    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("Spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("Spring2");
        repository.save(member2);

        Member member3 = new Member();
        member3.setName("Spring3");
        repository.save(member3);

        List<Member> result = repository.findAll();
        assertThat(result.size()).isEqualTo(3);
    }
}
