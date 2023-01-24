package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class singletonTest {
    @Test
    @DisplayName("호출할때마다 여러개의 객체가 생성")
    void pureContainer() {
        AppConfig appConfig = new AppConfig();

        //1.호출할떄마다 다 객체 생성
        MemberService memberService1 = appConfig.memberService();
        //2.호출할떄마다 다른 객체 생성
        MemberService memberService2 = appConfig.memberService();

        //참조값이 다른 것을 확인
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        //memberService1 != memberService2
        assertThat(memberService1).isNotSameAs(memberService2);
    }

    @Test
    @DisplayName("singleton call")
    void singleton(){
        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();
//        System.out.println("singletonService1 = " + singletonService1);
//        System.out.println("singletonService2 = " + singletonService2);
        assertThat(singletonService1).isSameAs(singletonService2);
    }
}
