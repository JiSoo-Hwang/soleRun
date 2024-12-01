package com.jisoo.solerun.service;

import com.jisoo.solerun.entity.Run;
import com.jisoo.solerun.repository.RunRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RunServiceImpl implements RunService{
    private final RunRepository runRepository;

    public RunServiceImpl(RunRepository runRepository){
        this.runRepository=runRepository;
    }
    //게시글 추가
    @Override
    public Run saveRun(Run run) {
        return runRepository.save(run);
    }
    //게시글 조회
    @Override
    public List<Run> selectRun() {
        return runRepository.findAll();
    }

    @Override
    public Run getRunById(Long id) {
        return runRepository.findById(id)
                .orElseThrow(()->new RuntimeException("해당 게시글을 찾을 수 없습니다."));
    }
}
