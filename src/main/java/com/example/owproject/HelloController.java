package com.example.owproject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private final TestService testService;

    public HelloController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping(value = "/api/hello", consumes = )
    public String hello() {
        return testService.test();
    }
}
