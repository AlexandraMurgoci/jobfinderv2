package com.topspec.jobfinderv2.Service;

import com.example.jobf.Domain.Job;
import org.springframework.data.domain.Page;

import java.util.List;

public interface JobService {
    Page<Job> findAll(int pageNumber, String sortField, String sortDirection);
    List<Job> findAll();
    Job findById(long id);
    Job save(Job job);
    void deleteById(long id);
}
