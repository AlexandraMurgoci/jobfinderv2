package com.topspec.jobfinderv2.Service;

import com.example.jobf.Domain.Application;
import com.example.jobf.Exceptions.ResourceNotFoundException;
import com.example.jobf.Repository.ApplicationRepository;
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
public class ApplicationServiceImpl implements ApplicationService{
    @Autowired
    ApplicationRepository applicationRepository;


    public ApplicationServiceImpl(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    @Override
    public Page<Application> findAll(int pageNumber, String sortField, String sortDirection) {


        Sort sort=Sort.by(sortField);
        sort=sortDirection.equals("asc") ? sort.ascending(): sort.descending();
        Pageable pageable= PageRequest.of(pageNumber-1,10,sort);

        List<Application> applications = new LinkedList<>();
        applicationRepository.findAll().iterator().forEachRemaining(applications
                ::add);
        log.info("Method findAll from ApplicationRepository was called: ");
        applications.forEach(app -> log.info(app.getStatus()));

        return applicationRepository.findAll(pageable);
    }

    @Override
    public List<Application> findAll() {
        List<Application> apps = new LinkedList<>();
        applicationRepository.findAll().iterator().forEachRemaining(apps
                ::add);
        return apps;
    }

    @Override
    public Application findById(long id) {
        Optional<Application> ok=applicationRepository.findById(id);
        if (!ok.isPresent()){
            throw new ResourceNotFoundException("Application not found!");
        }
        log.info("Method findById from ApplicationRepository was called for the application with id:"+id);
        return  ok.get();
    }


    @Override
    public Application save(Application application) {
        Application savedapp=applicationRepository.save(application);
        log.info("Method save from ApplicationRepository was called to add new application:"+application.getId());
        return savedapp;
    }

    @Override
    public void deleteById(long id) {
        Optional<Application> ok=applicationRepository.findById(id);
        if (!ok.isPresent()){
            throw new ResourceNotFoundException("Application not found!");
        }
        log.info("Method deleteById from ApplicationRepository was called to delete the application with id:"+id);
        applicationRepository.deleteById(id);
    }

    @Override
    public List<Application> findByUserapp_Id(long id) {
        List<Application> apps = new LinkedList<>();
        applicationRepository.findByUserapp_Id(id).iterator().forEachRemaining(apps
                ::add);
        return apps;
    }
}
