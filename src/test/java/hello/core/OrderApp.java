package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderApp {
    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder(){
        Member member = new Member("memberA",1L, Grade.VIP);
        memberService.join(member);
        Order order = orderService.createOrder(1L,"itemA",10000);

        Assertions.assertThat(order.Calculator()).isEqualTo(9000);
    }
}
