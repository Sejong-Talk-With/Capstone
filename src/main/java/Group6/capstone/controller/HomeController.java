package Group6.capstone.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {

    @RequestMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/custom")
    public String custom() {
        return "custom";
    }

    @GetMapping("/statics")
    public String statics() {
        return "charts";
    }
}
