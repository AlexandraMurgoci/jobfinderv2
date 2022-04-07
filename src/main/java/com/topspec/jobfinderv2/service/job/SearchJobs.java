package com.topspec.jobfinderv2.service.job;

import com.topspec.jobfinderv2.model.job.Job;
import com.topspec.jobfinderv2.repository.JobRepository;
import com.topspec.jobfinderv2.service.CustomPageImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static java.util.Objects.requireNonNull;

@Service
@Transactional
public class SearchJobs {

    private static final Logger LOGGER = LoggerFactory.getLogger(SearchJobs.class);

    private final JobRepository jobRepository;

    public SearchJobs(JobRepository jobRepository) {
        this.jobRepository = requireNonNull(jobRepository);
    }

    public CustomPageImpl<Job> findJobs(String searchParameter, Integer page) {
        Pageable pageRequest = PageRequest.of(page, 9, Sort.by("id").descending());
        Page<Job> jobs = searchParameter!= null ?
                jobRepository.findAllByTitleContainingIgnoreCaseOrCompanyContainingIgnoreCaseOrCityContainingIgnoreCase(searchParameter, searchParameter, searchParameter, pageRequest) :
                jobRepository.findAll(pageRequest);
        return new CustomPageImpl<>(jobs.getContent(),
                jobs.getTotalPages(), jobs.getTotalElements());
    }
}
