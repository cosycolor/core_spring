package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {
    DiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();
    
    
    
    @Test
    @DisplayName("VIP는 10%할인을 받아야 한다")
    void vip_o(){
        //given
        Member member = new Member("memberA",1L, Grade.VIP);

        //when
        int discount = rateDiscountPolicy.discountPolicy(member, 10000);

        //then
        Assertions.assertThat(discount).isEqualTo(1000);
    }
    @Test
    void vip_x(){
        //given
        Member member = new Member("memberA",1L, Grade.BASIC);

        //when
        int discount = rateDiscountPolicy.discountPolicy(member, 10000);

        //then
        Assertions.assertThat(discount).isEqualTo(0);
    }

}