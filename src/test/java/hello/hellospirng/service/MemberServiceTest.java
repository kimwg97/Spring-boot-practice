package hello.hellospirng.service;

import hello.hellospirng.domain.Member;
import hello.hellospirng.repository.MemberRepository;
import hello.hellospirng.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository repository;

    @BeforeEach
    public void beforeEach(){
        repository = new MemoryMemberRepository();
        memberService = new MemberService(repository);

    }

    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    void join() {

        //given
        Member member = new Member();
        member.setName("s");

        //when
        Long setId = memberService.Join(member);

        //then
        Member member1 = memberService.findOne(setId).get();
        assertThat(member.getName()).isEqualTo(member1.getName());
    }

    @Test
    public void duplicate(){
        //give
        Member member1 = new Member();
        member1.setName("s1");

        Member member2 = new Member();
        member2.setName("s1");

        //when
        memberService.Join(member1);

        IllegalStateException illegalStateException = assertThrows(IllegalStateException.class, () -> memberService.Join(member2));
        assertThat(illegalStateException.getMessage()).isEqualTo("이미 존재하는 회원입니다.");


        //then
    }

    @Test
    void findMember() {
    }

    @Test
    void findOne() {
    }
}