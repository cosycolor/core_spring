package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberApp {
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Test
    void join(){
        //given
        Member memberA = new Member("memberA", 1L, Grade.VIP);
        //when
        memberRepository.save(memberA);
        Member findById = memberRepository.findById(1L);
        //then
        Assertions.assertThat(memberA).isEqualTo(findById);
                
    }
}
