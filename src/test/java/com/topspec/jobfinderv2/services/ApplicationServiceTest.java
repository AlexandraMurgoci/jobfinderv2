package com.topspec.jobfinderv2.services;

import com.example.jobf.Domain.Application;
import com.example.jobf.Domain.Job;
import com.example.jobf.Domain.User;
import com.example.jobf.Repository.ApplicationRepository;
import com.example.jobf.Service.ApplicationService;
import com.example.jobf.Service.ApplicationServiceImpl;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class ApplicationServiceTest {

    ApplicationService applicationService;

    @Mock
    ApplicationRepository applicationRepository;

    @Rule
    public MockitoRule rule= MockitoJUnit.rule();

    @Before
    public void setUp() throws Exception{
        applicationService=new ApplicationServiceImpl(applicationRepository);
    }

    @Test
    @DisplayName("Find all jobs!")
    public void findJobs()
    {
        List<Application> apps=new ArrayList<>();
        Application application=new Application();
        application.setId(1L);
        Job job=new Job();
        job.setId(1L);
        User user=new User();
        user.setId(1L);
        application.setJobapp(job);
        application.setUserapp(user);

        apps.add(application);


        when(applicationRepository.findAll()).thenReturn(apps);
        List<Application> applicationList=applicationService.findAll();
        assertEquals(applicationList.size(),1);
        verify(applicationRepository,times(1)).findAll();
    }

    @Test
    @DisplayName("Find the application by id-HF")
    public void findById(){
        Application application=new Application();
        application.setId(1L);
        Job job=new Job();
        job.setId(1L);
        User user=new User();
        user.setId(1L);
        application.setJobapp(job);
        application.setUserapp(user);


        when(applicationRepository.findById(job.getId())).thenReturn(Optional.of(application));

        Optional<Application> result= Optional.ofNullable(applicationService.findById(application.getId()));

        assertEquals(result.isPresent(),true);

    }

    @Test
    @DisplayName("Find the application by id-ERR")
    public void findByIdERR(){
        Application application=new Application();
        application.setId(1L);
        Job job=new Job();
        job.setId(1L);
        User user=new User();
        user.setId(1L);
        application.setJobapp(job);
        application.setUserapp(user);

        RuntimeException result=assertThrows(RuntimeException.class,
                ()->applicationService.findById(application.getId()));

        assertEquals("Application not found!",result.getMessage());


    }


    @Test
    @DisplayName("Create a new application.")
    public void newJob(){
        Application application=new Application();
        application.setId(1L);
        Job job=new Job();
        job.setId(1L);
        User user=new User();
        user.setId(1L);
        application.setJobapp(job);
        application.setUserapp(user);

        when(applicationRepository.save(application)).thenReturn(application);
        Application result=applicationService.save(application);

        assertEquals(application.getId(),result.getId());



        verify(applicationRepository,times(1)).save(application);
    }

    @Test
    @DisplayName("Delete job by id")
    public void deleteById(){
        Application application=new Application();
        application.setId(1L);
        Job job=new Job();
        job.setId(1L);
        User user=new User();
        user.setId(1L);
        application.setJobapp(job);
        application.setUserapp(user);

        when(applicationRepository.findById(job.getId())).thenReturn(Optional.of(application));
        applicationService.deleteById(application.getId());

        verify(applicationRepository).deleteById(job.getId());

    }


    @Test
    @DisplayName("Delete job by id ERR")
    public void deleteByIdErr(){
        Application application=new Application();
        application.setId(1L);
        Job job=new Job();
        job.setId(1L);
        User user=new User();
        user.setId(1L);
        application.setJobapp(job);
        application.setUserapp(user);

        RuntimeException result=assertThrows(RuntimeException.class,
                ()->applicationService.findById(application.getId()));

        assertEquals("Application not found!",result.getMessage());

    }

}
