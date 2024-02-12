package kg.alatoo.beanlifecycledemo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BeanLifecycleDemoApplication implements BeanPostProcessor {

    public static void main(String[] args) {
        SpringApplication.run(BeanLifecycleDemoApplication.class, args);
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof MyBean)
            System.out.println("Bean post Process before init: " + bean.getClass().getName());
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof MyBean)
            System.out.println("Bean post Process after init: " + bean.getClass().getName());
        return bean;
    }

    @Bean(name = "myFirstBean",initMethod = "init", destroyMethod = "destroyMethod")
    public MyBean myCustomBean() {
        return new MyBean();
    }
}
