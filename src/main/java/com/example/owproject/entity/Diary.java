package com.example.owproject.entity;

import com.example.owproject.dto.request.DiaryAddReqDto;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.Instant;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Diary {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column
    private String title;

    @NotNull
    @Column
    private String content;

    @NotNull
    @Column(name = "created_at")
    private Instant cratedAt = Instant.now();

    @NotNull
    @Column(name = "updated_at")
    private Instant updatedAt = Instant.now();

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public static Diary ofAddDto(DiaryAddReqDto addDto) {

        Diary diary = new Diary();
        diary.title = addDto.getTitle();
        diary.content = addDto.getContent();

        return diary;
    }
}
