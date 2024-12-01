package com.jisoo.solerun.controller.api;

import com.jisoo.solerun.entity.Run;
import com.jisoo.solerun.service.RunService;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SoleRunApiController {
    private final RunService runService;

    public SoleRunApiController(RunService runService){
        this.runService=runService;
    }



}
