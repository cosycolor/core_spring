package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

public class FixedDiscountPolicy implements DiscountPolicy{
    private final int FixedDiscountAmount = 1000;
    @Override
    public int discountPolicy(Member member, int price) {
        if(member.getGrade() == Grade.VIP){
            return FixedDiscountAmount;
        }else{
            return 0;
        }
    }
}
