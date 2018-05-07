package app;

import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.json.simple.*;

@RestController
public class Controller {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }

    @RequestMapping("/cityRumble")
    public String cityRumble(@RequestParam(value = "name", defaultValue = "default") String name) {
        return name + " returned";
    }

    @RequestMapping("/cityCounter")
    public void cityCounter(@RequestParam(value = "name", defaultValue = "default") String name) {

        //add city to a list/set
        //add the counter to correct city
        //note:city list probably on its own city class
        //return method with top 6 counts 
    }

    @RequestMapping(value = "/city", method = RequestMethod.GET)
    @SuppressWarnings("unchecked")
    public JSONObject test() {
        JSONObject results = new JSONObject();

//        if (Model.mostSearchedCities.size() < 10) {
//            JSONArray ja = new JSONArray();
//            JSONObject obj = new JSONObject();
//            obj.put("name", "Helsinki");
//            ja.add(obj);
//            obj = new JSONObject();
//            obj.put("name", "Singapore");
//            ja.add(obj);
//            obj = new JSONObject();
//            obj.put("name", "Hong Kong");
//            ja.add(obj);
//            obj = new JSONObject();
//            obj.put("name", "New York");
//            ja.add(obj);
//            obj = new JSONObject();
//            obj.put("name", "Rome");
//            ja.add(obj);
//            obj = new JSONObject();
//            obj.put("name", "Los Angeles");
//            ja.add(obj);
//            obj = new JSONObject();
//            obj.put("name", "Seoul");
//            ja.add(obj);
//            obj = new JSONObject();
//            obj.put("name", "Athens");
//            ja.add(obj);
//            obj = new JSONObject();
//            obj.put("name", "Tokyo");
//            ja.add(obj);
//            obj = new JSONObject();
//            obj.put("name", "Kyoto");
//            ja.add(obj);
//            results.put("results", ja);
//        } else {
//            JSONArray ja = new JSONArray();
//            JSONObject obj;
//            for (String s : Model.mostSearchedCities.keySet()) {
//                obj = new JSONObject();
//                obj.put("name", s);
//                ja.add(obj);
//            }
//            results.put("results", ja);
//        }
        JSONArray ja = new JSONArray();
        JSONObject obj;
        for (String s : Model.mostSearchedCities.keySet()) {
            obj = new JSONObject();
            obj.put("name", s);
            ja.add(obj);
        }
        results.put("results", ja);

        return results;
    }

    @RequestMapping(value = "/city", method = RequestMethod.POST)
    public String cityNameSearched(@RequestBody String cityName) {
        System.out.println(Model.mostSearchedCities.size());
        System.out.println("-------------");
        if (Model.cityList.containsKey(cityName)) {
            int newCount = Model.cityList.get(cityName) + 1;
            Model.cityList.put(cityName, newCount);

            int smallest = Integer.MAX_VALUE;
            for (Map.Entry<String, Integer> entry : Model.mostSearchedCities.entrySet()) {
                if (smallest > entry.getValue()) {
                    smallest = entry.getValue();
                }
            }

            if (newCount > smallest) {
                if (Model.mostSearchedCities.size() >= 10) {
                    for (String s : Model.mostSearchedCities.keySet()) {
                        if (Model.mostSearchedCities.get(s) == smallest) {
                            if(Model.mostSearchedCities.size() >= 10) {
                                Model.mostSearchedCities.remove(s);
                            }                           
                            break;
                        }
                    }
                }

                Model.mostSearchedCities.put(cityName, newCount);
            }
        } else {
            Model.cityList.put(cityName, 1);
        }

        return "successfully added";
    }
}
