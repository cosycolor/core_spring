package hello.core.scope;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static org.assertj.core.api.Assertions.*;

public class SingletonScope {
    @Test
    void singletonBeanFind(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SingletonBean.class);
        SingletonBean bean1 = ac.getBean(SingletonBean.class);
        SingletonBean bean2 = ac.getBean(SingletonBean.class);
        assertThat(bean1).isSameAs(bean2);
        ac.close();

    }
    @Scope("singleton")
    static class SingletonBean{
        private final String LE;
        @PostConstruct
        public void init(){
            System.out.println("init.hello");
        }
        SingletonBean(){
            LE = "constructor";
            System.out.println("LE = " + LE);
        }
        @PreDestroy
        public void destroy(){
            System.out.println("destroy.hello");
        }
    }
}
