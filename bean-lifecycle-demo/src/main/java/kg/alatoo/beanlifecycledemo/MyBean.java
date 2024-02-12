package kg.alatoo.beanlifecycledemo;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;


public class MyBean implements BeanNameAware, BeanFactoryAware,
        ApplicationContextAware, InitializingBean, DisposableBean {

    private String beanName;


    public void init() {
        System.out.println("Custom bean init() method");
    }

    @PostConstruct
    public void customInit() {
        System.out.println("Custom bean customInit() method");
    }



    public void destroyMethod() {
        System.out.println("Custom bean destroyMethod() method");
    }

    @PreDestroy
    public void customDestroy() {
        System.out.println("Custom bean customDestroy() method");
    }

    @Override
    public void setBeanName(String name) {
        this.beanName = name;
        System.out.println("setBeanName(" + name + ")");
    }


    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("setBeanFactory("+ beanFactory.getClass().getName() +")");
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("setApplicationContext("+ applicationContext.getClass().getName() +")");

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet()");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destroy method by DisposableBean");
    }
}
