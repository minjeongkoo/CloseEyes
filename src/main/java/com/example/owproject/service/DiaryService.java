package com.example.owproject.service;

import com.example.owproject.dto.response.DiaryResDto;
import com.example.owproject.entity.Diary;
import com.example.owproject.repository.DiaryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Slf4j
@Service
public class DiaryService {

    private final DiaryRepository diaryRepository;

    public List<DiaryResDto> getList() {

        List<Diary> diaryList = diaryRepository.findAll();

        List<DiaryResDto> diaryResDtos = new ArrayList<>();
        for (Diary diary : diaryList) {
            DiaryResDto diaryResDto = new DiaryResDto(
                    diary.getId(),
                    diary.getTitle(),
                    LocalDateTime.ofInstant(diary.getCratedAt(), ZoneId.systemDefault()));
            diaryResDtos.add(diaryResDto);
        }

        return diaryResDtos;

    }
}
