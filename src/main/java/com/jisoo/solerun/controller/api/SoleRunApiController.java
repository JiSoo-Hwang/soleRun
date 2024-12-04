package com.jisoo.solerun.controller.api;

import com.jisoo.solerun.dto.RunUpdateDto;
import com.jisoo.solerun.entity.Run;
import com.jisoo.solerun.service.RunService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class SoleRunApiController {
    private final RunService runService;

    public SoleRunApiController(RunService runService){
        this.runService=runService;
    }

    @PostMapping("/update.do")
    public ResponseEntity<Map<String,String>> updateRun(@RequestBody RunUpdateDto runUpdateDto){
        boolean updateYN = runService.updateRun(runUpdateDto);
        Map<String,String> response = new HashMap<>();
        if(updateYN){
            response.put("status","success");
            response.put("message","글이 성공적으로 수정되었습니다.");
        }else{
            response.put("status","error");
            response.put("message","글 수정에 실패했습니다. 다시 시도해주세요.");
        }
        return ResponseEntity.ok(response);
    }

    @GetMapping("/myRun/delete/{id}")
    public ResponseEntity<Map<String,String>> deleteRun(@PathVariable Long id){
        boolean deleteYN = runService.deleteRun(id);
        Map<String,String> response = new HashMap<>();
        if(deleteYN){
            response.put("status","success");
            response.put("message","글이 성공적으로 삭제되었습니다.");
        }else{
            response.put("status","error");
            response.put("message","글 삭제 실패, 다시 시도해주세요");
        }
        return ResponseEntity.ok(response);
    }
}
