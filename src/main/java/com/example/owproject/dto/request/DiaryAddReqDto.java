package com.example.owproject.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class DiaryAddReqDto {

    @NotBlank
    private String title;

    @NotBlank
    private String content;
}
