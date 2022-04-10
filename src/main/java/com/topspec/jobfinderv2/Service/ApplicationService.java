package com.topspec.jobfinderv2.Service;

import com.example.jobf.Domain.Application;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ApplicationService {
    Page<Application> findAll(int pageNumber, String sortField, String sortDirection);
    List<Application> findAll();
    Application findById(long id);
    Application save(Application application);
    void deleteById(long id);
    List<Application> findByUserapp_Id(long id);
}
