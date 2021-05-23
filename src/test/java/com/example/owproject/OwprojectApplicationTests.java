package com.example.owproject;

import com.example.owproject.repository.DiaryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OwprojectApplicationTests {

    @Autowired
    private DiaryRepository diaryRepository;

    @Test
    void contextLoads() {
    }

}
