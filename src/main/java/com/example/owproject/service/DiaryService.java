package com.example.owproject.service;

import com.example.owproject.dto.request.DiaryAddReqDto;
import com.example.owproject.dto.request.DiaryModifyReqDto;
import com.example.owproject.dto.response.DiaryDetailResDto;
import com.example.owproject.dto.response.DiaryResDto;
import com.example.owproject.entity.Diary;
import com.example.owproject.repository.DiaryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ValidationException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
public class DiaryService {

    private final DiaryRepository diaryRepository;

    @Transactional(readOnly = true)
    public List<DiaryResDto> getList() {

        List<Diary> diaryList = diaryRepository.findAll();

        List<DiaryResDto> diaryResList = new ArrayList<>();
        for (Diary diary : diaryList) {
            DiaryResDto diaryResDto = new DiaryResDto(
                    diary.getId(),
                    diary.getTitle(),
                    LocalDateTime.ofInstant(diary.getCratedAt(), ZoneId.systemDefault()));
            diaryResList.add(diaryResDto);
        }

        return diaryResList;

    }

    @Transactional(readOnly = true)
    public DiaryDetailResDto get(long id) {

        Diary diary = diaryRepository.findById(id).orElseThrow(ValidationException::new);

        return getDiaryDetailResDto(diary);
    }

    @Transactional
    public DiaryDetailResDto add(DiaryAddReqDto req) {

        Diary diary = Diary.ofAddDto(req);
        diaryRepository.save(diary);

        return getDiaryDetailResDto(diary);
    }

    @Transactional
    public DiaryDetailResDto modify(DiaryModifyReqDto req) {

        Diary diary = diaryRepository.findById(req.getId()).orElseThrow(ValidationException::new);
        diary.update(req.getTitle(), req.getContent());

        return getDiaryDetailResDto(diary);
    }

    @Transactional
    public void delete(long id) {

        Diary diary = diaryRepository.findById(id).orElseThrow(ValidationException::new);

        diaryRepository.delete(diary);
    }


    private DiaryDetailResDto getDiaryDetailResDto(Diary diary) {
        return new DiaryDetailResDto(
                diary.getId(),
                diary.getTitle(),
                diary.getContent(),
                LocalDateTime.ofInstant(diary.getCratedAt(), ZoneId.systemDefault())
        );
    }
}
