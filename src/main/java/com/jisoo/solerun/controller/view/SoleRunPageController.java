package com.jisoo.solerun.controller.view;

import com.jisoo.solerun.dto.RunUpdateDto;
import com.jisoo.solerun.entity.Run;
import com.jisoo.solerun.service.RunService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class SoleRunPageController {
    private final RunService runService;

    public SoleRunPageController(RunService runService){
        this.runService=runService;
    }

    @GetMapping("/myRunList.do")
    public ModelAndView myRunList(ModelAndView mv){
        List<Run>runs = runService.selectRun();
        mv.addObject("runs",runs).setViewName("myRun/myRunList");
        return mv;
    }

    @GetMapping("/myRunForm.do")
    public String myRunForm(){
        return "myRun/myRunForm";
    }

    @PostMapping("/myRun/save.do")
    public String saveRun(@ModelAttribute Run run){
        runService.saveRun(run);
        return "redirect:/myRunList.do";
    }

    @GetMapping("/myRun/detail/{id}")
    public String getRunDetail(@PathVariable Long id, Model model){
        Run run = runService.getRunById(id);
        model.addAttribute("run",run);
        return "myRun/myRunDetail";
    }

    @GetMapping("/myRun/update/{id}")
    public String updateRunPage(@PathVariable Long id, Model model){
        Run run = runService.getRunById(id);
        model.addAttribute("run",run);
        return "myRun/myRunUpdate";
    }


}
