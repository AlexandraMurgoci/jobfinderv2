package com.topspec.jobfinderv2.controller.job;

import com.topspec.jobfinderv2.model.job.Job;
import com.topspec.jobfinderv2.service.job.GetJob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

import static org.springframework.http.ResponseEntity.notFound;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/job")
@CrossOrigin("http://localhost:4200")
public class JobController {

    @Autowired
    private GetJob getJob;

    @GetMapping("/view/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable("id") Integer id) {
        try {
            return ok(getJob.getById(id));
        }
        catch (NoSuchElementException e) {
            return notFound().build();
        }
    }
}
