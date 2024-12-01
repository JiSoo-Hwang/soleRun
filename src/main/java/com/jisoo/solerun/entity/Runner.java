package com.jisoo.solerun.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Runner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long runnerId; // Primary Key

    private String userId; // 사용자 ID

    private String userPwd; // 사용자 비밀번호

    @OneToMany(mappedBy = "runner", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Run> runs; // 연관된 게시글 리스트
}