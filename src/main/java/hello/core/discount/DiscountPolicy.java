package hello.core.discount;

import hello.core.member.Member;

public interface DiscountPolicy {
    public int discountPolicy(Member member,int price);
}
