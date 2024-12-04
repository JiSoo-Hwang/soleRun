package com.jisoo.solerun.service;

import com.jisoo.solerun.dto.RunUpdateDto;
import com.jisoo.solerun.entity.Run;
import java.util.List;

public interface RunService {
    Run saveRun(Run run);
    List<Run> selectRun();
    Run getRunById(Long id);
    boolean updateRun(RunUpdateDto dto);
    boolean deleteRun(Long id);
}
