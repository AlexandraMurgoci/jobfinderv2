package com.topspec.jobfinderv2.service.job;

import com.topspec.jobfinderv2.model.job.Job;
import com.topspec.jobfinderv2.repository.JobRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static java.util.Objects.requireNonNull;

@Service
@Transactional
public class CreateOrUpdateJob {
    private static final Logger LOGGER = LoggerFactory.getLogger(CreateOrUpdateJob.class);

    private final JobRepository jobRepository;

    public CreateOrUpdateJob(JobRepository jobRepository) {
        this.jobRepository = requireNonNull(jobRepository);
    }

    public Job save(Job job) {
        Job savedJob = jobRepository.save(job);
        LOGGER.info("Method save from JobRepository was called to add new category: " + job.getTitle());
        return savedJob;
    }
}
