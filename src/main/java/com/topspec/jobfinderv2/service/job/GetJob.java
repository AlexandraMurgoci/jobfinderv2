package com.topspec.jobfinderv2.service.job;

import com.topspec.jobfinderv2.model.job.Job;
import com.topspec.jobfinderv2.repository.JobRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;
import java.util.Optional;

import static java.util.Objects.requireNonNull;

@Service
@Transactional
public class GetJob {
    private static final Logger LOGGER = LoggerFactory.getLogger(GetJob.class);

    private final JobRepository jobRepository;

    public GetJob(JobRepository jobRepository) {
        this.jobRepository = requireNonNull(jobRepository);
    }

    public Job getById(Integer id) {
        Optional<Job> ok = jobRepository.findById(id);
        if (!ok.isPresent()){
            throw new NoSuchElementException("Job not found!");
        }
        LOGGER.info("Method findById from JobRepository was called for the category with id:"+id);
        return  ok.get();
    }

}
