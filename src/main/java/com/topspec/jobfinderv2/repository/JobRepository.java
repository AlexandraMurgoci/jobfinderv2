package com.topspec.jobfinderv2.repository;

import com.topspec.jobfinderv2.model.job.Job;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends PagingAndSortingRepository<Job,Integer> {
}
