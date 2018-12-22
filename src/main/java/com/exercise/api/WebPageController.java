package com.exercise.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebPageController {
    @RequestMapping("/home")
    public String home() {
        return "index";
    }
}
