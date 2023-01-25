package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.stereotype.Component;

@Component
public class RateDiscountPolicy implements DiscountPolicy{
    private final int discountRate = 10;


    @Override
    public int discountPolicy(Member member, int price) {
        if(member.getGrade().equals(Grade.VIP)){
            return price * discountRate/100;
        }else{
            return 0;
        }

    }
}
