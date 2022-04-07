package com.topspec.jobfinderv2.repository;

import com.topspec.jobfinderv2.model.job.Job;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<Job,Integer> {

    Page<Job> findAllByTitleContainingIgnoreCaseOrCompanyContainingIgnoreCaseOrCityContainingIgnoreCase(String searchParam1, String searchParam2, String searchParam3, Pageable pageable);
}
