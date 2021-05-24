package com.example.owproject.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;

@NoArgsConstructor
@Getter
@Entity
public class Diary {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String content;

    @Column(name = "created_at")
    private Instant cratedAt = Instant.now();

    @Column(name = "updated_at")
    private Instant updatedAt = Instant.now();

    public void updateTitle(String title) {
        this.title = title;
    }
}
