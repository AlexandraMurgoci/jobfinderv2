package com.topspec.jobfinderv2.Repository;

import com.example.jobf.Domain.Job;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends PagingAndSortingRepository<Job,Long> {
}
