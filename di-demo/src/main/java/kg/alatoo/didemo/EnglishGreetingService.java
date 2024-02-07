package kg.alatoo.didemo;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service("i18nGreetingService")
@Profile({"EN","default"})
public class EnglishGreetingService implements GreetingService {

    public EnglishGreetingService() {
        System.out.println("EnglishGreetingService created");

    }

    @Override
    public String provideHello() {
        System.out.println("Inside of EnglishGreetingService");
        return "Hello, World!";
    }
}
