package app;

import java.util.Map;
import java.util.Set;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        Model.cityList.put("Helsinki", 10);
        Model.cityList.put("Singapore", 9);
        Model.cityList.put("Hong Kong", 8);
        Model.cityList.put("New York", 7);
        Model.cityList.put("Rome", 6);
        Model.cityList.put("Los Angeles", 5);
        Model.cityList.put("Seoul", 4);
        Model.cityList.put("Athens", 3);
        Model.cityList.put("Tokyo", 2);
        Model.cityList.put("Bangkok", 1);
        Model.mostSearchedCities.put("Helsinki", 10);
        Model.mostSearchedCities.put("Singapore", 9);
        Model.mostSearchedCities.put("Hong Kong", 8);
        Model.mostSearchedCities.put("New York", 7);
        Model.mostSearchedCities.put("Rome", 6);
        Model.mostSearchedCities.put("Los Angeles", 5);
        Model.mostSearchedCities.put("Seoul", 4);
        Model.mostSearchedCities.put("Athens", 3);
        Model.mostSearchedCities.put("Tokyo", 2);
        Model.mostSearchedCities.put("Bangkok", 1);
        SpringApplication.run(App.class, args);
    }
}
