package com.example.owproject;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HelloController {

    private final TestService testService;

    public HelloController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping(value = "/api/hello")
    public String hello() {

        log.error("asdasdas");

        return testService.test();
    }
}
