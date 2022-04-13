package com.topspec.jobfinderv2.controller.hr;

import com.topspec.jobfinderv2.model.job.Job;
import com.topspec.jobfinderv2.service.job.CreateOrUpdateJob;
import com.topspec.jobfinderv2.service.job.DeleteJob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/hr")
@CrossOrigin("http://localhost:4200")
public class HrManageJobsController {

    @Autowired
    private CreateOrUpdateJob createOrUpdateJob;
    @Autowired
    private DeleteJob deleteJob;

    @PostMapping("/job/create-or-update")
    public Job saveOrUpdate(@Valid @RequestBody Job job) {
        return createOrUpdateJob.save(job);
    }

    @PostMapping("/job/delete")
    public void deleteJobById(@RequestBody Job job) {
        deleteJob.byId(job.getId());
    }
}
