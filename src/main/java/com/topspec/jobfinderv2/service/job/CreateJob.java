package com.topspec.jobfinderv2.service.job;

import com.topspec.jobfinderv2.model.job.Job;
import com.topspec.jobfinderv2.repository.JobRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static java.util.Objects.requireNonNull;

@Service
@Transactional
public class CreateJob {

    private final JobRepository jobRepository;

    public CreateJob(JobRepository jobRepository) {
        this.jobRepository = requireNonNull(jobRepository);
    }

    public Job save(Job job) {
        return null;
    }
}
