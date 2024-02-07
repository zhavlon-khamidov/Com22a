package kg.alatoo.didemo;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service("i18nGreetingService")
@Profile("RU")
public class RussianGreetingService implements GreetingService{

    public RussianGreetingService() {
        System.out.println("RussianGreetingService created");
    }

    @Override
    public String provideHello() {
        return "Привет, Мир!";
    }
}
