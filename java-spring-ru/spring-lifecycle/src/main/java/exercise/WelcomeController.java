package exercise;


import exercise.daytimes.Daytime;
import org.springframework.web.bind.annotation.GetMapping;


// BEGIN
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
@RestController

public class WelcomeController {
    @Autowired
    Daytime daytime;

    @Autowired
    Meal meal;

    @GetMapping(path = "/daytime")
    public String root() {
        String time = daytime.getName();
        return "It is" + time + "now. Enjoy your" + meal.getMealForDaytime(time);
    }
}
// END
