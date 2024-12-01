package com.jisoo.solerun.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Run {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long runId; // Primary Key

    private String runTitle; // 게시글 제목

    private LocalDate postDate; // 게시글 작성 날짜

    private String runStory; // 게시글 내용

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "runner_id") // FK 컬럼 이름 설정
    private Runner runner; // 작성자 정보
}
