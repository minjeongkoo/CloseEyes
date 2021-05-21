package com.example.owproject;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@CrossOrigin("localhost:8080")
@RestController
public class HomeViewController {
    @RequestMapping("/api/homeview")
    public String homeview() {
        return "homeData";
    }
}