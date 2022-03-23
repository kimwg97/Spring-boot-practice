package hello.hellospirng.repository;

import hello.hellospirng.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("I");

        repository.save(member);
        Member result = repository.findByName("I").get();
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("2");
        repository.save(member2);

        Member result = repository.findByName("2").get();

        assertThat(member2).isEqualTo(result);
    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }

}
