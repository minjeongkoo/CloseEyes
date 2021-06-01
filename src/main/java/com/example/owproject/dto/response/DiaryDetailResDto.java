package com.example.owproject.dto.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class DiaryDetailResDto {

    private long id;

    private String title;

    private String content;

    private LocalDateTime createdAt;
}
