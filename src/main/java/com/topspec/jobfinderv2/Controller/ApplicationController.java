package com.topspec.jobfinderv2.Controller;

import com.example.jobf.Domain.Application;
import com.example.jobf.Domain.Job;
import com.example.jobf.Domain.User;
import com.example.jobf.Service.ApplicationService;
import com.example.jobf.Service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ApplicationController {
    @Autowired
    ApplicationService applicationService;

    @Autowired
    JobService jobService;

    @RequestMapping("/app/list")
    public String AppList(Model model) {
        return listByPage(model, 1, "id", "asc");
    }

    @GetMapping("/app/list/page/{pageNumber}")
    public String listByPage(
            Model model,
            @PathVariable("pageNumber") int currentPage,
            @Param("sortField") String sortField,
            @Param("sortDirection") String sortDirection) {
        Page<Application> page = applicationService.findAll(currentPage, sortField, sortDirection);
        long totalItems = page.getTotalElements();
        int totalPages = page.getTotalPages();
        List<Application> apps = page.getContent();

        model.addAttribute("currentPage", currentPage);
        model.addAttribute("apps", apps);
        model.addAttribute("totalItems", totalItems);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDirection", sortDirection);
        String reversesortDir = sortDirection.equals("asc") ? "desc" : "asc";
        model.addAttribute("reversesortDir", reversesortDir);

        return "applications";
    }

    @RequestMapping("/app/delete/{id}")
    public String deleteById(@PathVariable String id) {
        applicationService.deleteById(Long.valueOf(id));
        return "redirect:/app/list";
    }

    @RequestMapping("/app/{id}")
    public String saveOrUpdate(@PathVariable String id) {

        Application saveApp =new Application();
        saveApp.setStatus("Registered");
        Job job=jobService.findById(Long.valueOf(id));
        User user=new User();
        user.setId(1L);

        saveApp.setUserapp(user);
        saveApp.setJobapp(job);

                applicationService.save(saveApp);

        return "redirect:/job/list";
    }

    @RequestMapping("/app/updatestatus/{id}")
    public String updateStatusA(@PathVariable String id,@RequestParam String status){

        Application app = applicationService.findById(Long.valueOf(id));
            app.setStatus(status);
        applicationService.save(app);
        return "redirect:/app/list";
    }

@GetMapping("/app/list2")
public String listByPage2( Model model){
    List<Application> apps =applicationService.findByUserapp_Id(2l);
    model.addAttribute("apps", apps);
    return "applications2";
}

}
