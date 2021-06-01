package com.example.owproject.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class DiaryModifyReqDto extends DiaryAddReqDto {

    @NotNull
    private Long id;
}
