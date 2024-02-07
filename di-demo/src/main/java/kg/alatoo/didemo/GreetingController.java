package kg.alatoo.didemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

@Controller
public class GreetingController {


    private String testText;


    private GreetingService greetingService;

    public String sayHello() {
        System.out.println("Inside of GreetingController");

        System.out.println("testText = " + testText);
        return greetingService.provideHello();
    }


    @Autowired
    @Qualifier("i18nGreetingService")
    public void setGreetingService(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @Value("${my.text}")
    public void setTestText(String testText) {
        this.testText = testText;
    }
}
