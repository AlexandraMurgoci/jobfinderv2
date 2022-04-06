package com.topspec.jobfinderv2.Controller;

import com.example.jobf.Domain.Job;
import com.example.jobf.Service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class JobController {
    @Autowired
    JobService jobService;
    @RequestMapping("/job/list")
    public String JobList(Model model){
        return listByPage(model,1,"id","asc");
    }

    @GetMapping("/job/list/page/{pageNumber}")
    public String listByPage(
            Model model,
            @PathVariable("pageNumber") int currentPage,
            @Param("sortField") String sortField,
            @Param("sortDirection") String sortDirection)
    {
        Page<Job> page= jobService.findAll(currentPage,sortField,sortDirection);
        long totalItems= page.getTotalElements();
        int totalPages= page.getTotalPages();
        List<Job> jobs=page.getContent();

        model.addAttribute("currentPage",currentPage);
        model.addAttribute("jobs",jobs);
        model.addAttribute("totalItems",totalItems);
        model.addAttribute("totalPages",totalPages);
        model.addAttribute("sortField",sortField);
        model.addAttribute("sortDirection",sortDirection);
        String reversesortDir=sortDirection.equals("asc") ? "desc" :"asc";
        model.addAttribute("reversesortDir",reversesortDir);

        return "jobs";
    }

    @RequestMapping("/job/info/{id}")
    public String showById(@PathVariable String id, Model model){
        model.addAttribute("job",jobService.findById(Long.valueOf(id)));
        return "jobinfo";
    }

    @RequestMapping("/job/delete/{id}")
    public String deleteById(@PathVariable String id){
        jobService.deleteById(Long.valueOf(id));
        return "redirect:/job/list";
    }

    @RequestMapping("/job/new")
    public String newJob(Model model){
        model.addAttribute("job",new Job());
        return "jobForm";
    }
    @PostMapping("/job")
    public String saveOrUpdate(@Valid @ModelAttribute Job job, BindingResult bindingResult){


        if (bindingResult.hasErrors()){
            return "jobForm";
        }
        Job saveJob=jobService.save(job);
        return "redirect:/job/list";
    }
    //new add
    @RequestMapping("/job/update/{id}")
    public ModelAndView updateProdusById(@PathVariable String id,Model model){
        ModelAndView modelAndView = new ModelAndView("jobForm");
        Job job = jobService.findById(Long.valueOf(id));
        modelAndView.addObject("job",job);
        return modelAndView;
    }
}
