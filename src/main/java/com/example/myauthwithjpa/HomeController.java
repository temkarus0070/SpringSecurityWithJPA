package com.example.myauthwithjpa;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping(value = "/")
    public String home() {
        return "home.html";
    }

    @PostMapping(value = "/post")
    public String add(@RequestParam String str) {
        return str;
    }

    @GetMapping(value = "/secret")
    public String secrets() {
        return "CIA secrets";
    }
}
