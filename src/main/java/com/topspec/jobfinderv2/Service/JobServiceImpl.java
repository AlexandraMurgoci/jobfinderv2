package com.topspec.jobfinderv2.Service;


import com.example.jobf.Domain.Job;
import com.example.jobf.Exceptions.ResourceNotFoundException;
import com.example.jobf.Repository.JobRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class JobServiceImpl  implements JobService{
    @Autowired
    JobRepository jobRepository;


    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public Page<Job> findAll(int pageNumber, String sortField, String sortDirection) {


        Sort sort=Sort.by(sortField);
        sort=sortDirection.equals("asc") ? sort.ascending(): sort.descending();
        Pageable pageable= PageRequest.of(pageNumber-1,10,sort);

        List<Job> jobs = new LinkedList<>();
        jobRepository.findAll().iterator().forEachRemaining(jobs
                ::add);
        log.info("Method findAll from JobRepository was called: ");
        jobs.forEach(job -> log.info(job.getTitle()));

        return jobRepository.findAll(pageable);
    }

    @Override
    public List<Job> findAll() {
        List<Job> jobs = new LinkedList<>();
        jobRepository.findAll().iterator().forEachRemaining(jobs
                ::add);
        return jobs;
    }

    @Override
    public Job findById(long id) {
        Optional<Job> ok=jobRepository.findById(id);
        if (!ok.isPresent()){
            throw new ResourceNotFoundException("Job not found!");
        }
        log.info("Method findById from JobRepository was called for the category with id:"+id);
        return  ok.get();
    }


    @Override
    public Job save(Job job) {
        Job savedjob=jobRepository.save(job);
        log.info("Method save from JobRepository was called to add new category:"+job.getTitle());
        return savedjob;
    }

    @Override
    public void deleteById(long id) {
        Optional<Job> ok=jobRepository.findById(id);
        if (!ok.isPresent()){
            throw new ResourceNotFoundException("Job not found!");
        }
        log.info("Method deleteById from JobRepository was called to delete the job with id:"+id);
        jobRepository.deleteById(id);
    }
}
