package app;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
    
    @RequestMapping("/cityRumble")
    public String cityRumble(@RequestParam(value="name", defaultValue="default") String name) {
        return name+" returned";
    }
    
    @RequestMapping("/cityCounter")
    public void cityCounter(@RequestParam(value="name", defaultValue="default") String name) {
        
        
        //add city to a list/set
        
        //add the counter to correct city
        
        //note:city list probably on its own city class
        
        //return method with top 6 counts 
    }
    
}
