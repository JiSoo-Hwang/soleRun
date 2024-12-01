package com.jisoo.solerun.controller.view;

import com.jisoo.solerun.entity.Run;
import com.jisoo.solerun.service.RunService;
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

    @GetMapping("/")
    public String mainPage(Model model){
        model.addAttribute("logoText","SoleRun");
        return "main/index";
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
        return "redirect:/myrunlist.do";
    }

    @GetMapping("/myRunDetail.do")
    public String getRunDetail(@PathVariable Long id, Model model){
        Run run = runService.getRunById(id);
        model.addAttribute("run",run);
        return "myRun/myRunDetail";
    }
}
