package com.mvcPractice.practicespring;

import com.mvcPractice.practicespring.repository.MemberRepository;
import com.mvcPractice.practicespring.repository.MemoryMemberRepository;
import com.mvcPractice.practicespring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//직접 빈 등록
@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}
