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
public class DeleteJob {

    private static final Logger LOGGER = LoggerFactory.getLogger(DeleteJob.class);

    private final JobRepository jobRepository;

    public DeleteJob(JobRepository jobRepository) {
        this.jobRepository = requireNonNull(jobRepository);
    }

    public void byId(Integer id) {
        Optional<Job> ok=jobRepository.findById(id);
        if (!ok.isPresent()){
            throw new NoSuchElementException("Job not found!");
        }
        LOGGER.info("Method deleteById from JobRepository was called to delete the job with id:"+id);
        jobRepository.deleteById(id);
    }
}
