package com.jisoo.solerun.service;

import com.jisoo.solerun.dto.RunUpdateDto;
import com.jisoo.solerun.entity.Run;
import com.jisoo.solerun.repository.RunRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RunServiceImpl implements RunService{
    private final RunRepository runRepository;

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

    @Override
    @Transactional
    public boolean updateRun(RunUpdateDto dto) {
        Optional<Run> optionalRun = runRepository.findById(dto.getId());
        if(optionalRun.isPresent()){
            Run run = optionalRun.get();
            run.setRunTitle(dto.getTitle());
            run.setRunStory(dto.getStory());
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteRun(Long id) {
        Optional<Run> optionalRun = runRepository.findById(id);
        if(optionalRun.isPresent()){
            runRepository.deleteById(id);
            return true;
        }
        return false;
    }


}
