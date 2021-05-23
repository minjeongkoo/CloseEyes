package com.example.owproject.repository;

import com.example.owproject.entity.Diary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiaryRepository extends JpaRepository<Diary, Long> {

    Diary findByTitle(String title);
}
