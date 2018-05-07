package app;

import java.util.Map;
import java.util.Set;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {
    
    static Set<String> cityList;
    static Map<String, Integer> cityListCount;

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
