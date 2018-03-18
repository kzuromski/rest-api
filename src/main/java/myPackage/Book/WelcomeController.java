package myPackage.Book;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Created by Krzysiek on 18.03.2018.
 */
@Controller
public class WelcomeController
{
    @Value("${welcome.message:test}")
    private String message = "Welcome to my Spring REST API";

    @RequestMapping("/")
    public String welcomeMessage(Model model)
    {
        model.addAttribute("message", "Welcome to my Spring REST API");
        return "welcome";
    }
}
