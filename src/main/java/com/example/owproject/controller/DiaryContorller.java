package com.example.owproject.controller;

import com.example.owproject.dto.response.DiaryResDto;
import com.example.owproject.service.DiaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("api/")
@RestController
public class DiaryContorller {

    private final DiaryService diaryService;

    @GetMapping("/diary")
    public List<DiaryResDto> getDiaryList() {

        return diaryService.getList();
    }

}
