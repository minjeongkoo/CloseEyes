package com.example.owproject.controller;

import com.example.owproject.dto.request.DiaryAddReqDto;
import com.example.owproject.dto.request.DiaryModifyReqDto;
import com.example.owproject.dto.response.DiaryDetailResDto;
import com.example.owproject.dto.response.DiaryResDto;
import com.example.owproject.service.DiaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("api/")
@RestController
public class DiaryContorller {

    private final DiaryService diaryService;

    @GetMapping("/diaries")
    public List<DiaryResDto> getDiaries() {

        return diaryService.getList();
    }

    @GetMapping("/diaries/{id}")
    public DiaryDetailResDto getDiary(@PathVariable long id) {

        return diaryService.get(id);
    }

    @PostMapping("/diaries")
    public DiaryDetailResDto addDiary(@Validated @RequestBody DiaryAddReqDto req) {

        return diaryService.add(req);
    }

    @PatchMapping("/diaries")
    public DiaryDetailResDto modifyDiary(@Validated @RequestBody DiaryModifyReqDto req) {

        return diaryService.modify(req);
    }

    @DeleteMapping("/diaries/{id}")
    public void deleteDiary(@PathVariable long id) {

        diaryService.delete(id);
    }

}
