package hello.core;

import hello.core.discount.FixedDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderServiceImpl;

public class AppConfig {
    public MemberService memberService(){
        return new MemberServiceImpl(getMemberRepository());
    }

    private static MemoryMemberRepository getMemberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderServiceImpl orderService(){
        return new OrderServiceImpl(getMemberRepository(), getDiscountPolicy());
    }

    private static FixedDiscountPolicy getDiscountPolicy() {
        return new FixedDiscountPolicy();
    }

}
