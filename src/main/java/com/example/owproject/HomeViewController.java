package com.example.owproject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class HomeViewController {
    @RequestMapping("/api/homeview")
    public String homeview() {
        return "homeData";
    }
}
//
//@RestController
//public class TestController {
//
//    @RequestMapping("/test1")
//    public Blog test1(){
//
//        Blog blog = new Blog();
//
//        blog.setTitle("테스트1");
//        blog.setContent("테스트1 내용");
//
//        return blog;
//
//    }
//}

