package com.topspec.jobfinderv2.services;
import com.example.jobf.Domain.Job;
import com.example.jobf.Repository.JobRepository;
import com.example.jobf.Service.JobService;
import com.example.jobf.Service.JobServiceImpl;
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


public class JobServiceTest {

    JobService jobService;

    @Mock
    JobRepository jobRepository;

    @Rule
    public MockitoRule rule= MockitoJUnit.rule();

    @Before
    public void setUp() throws Exception{
        jobService=new JobServiceImpl(jobRepository);
    }

    @Test
    @DisplayName("Find all jobs!")
    public void findJobs()
    {
        List<Job> jobs=new ArrayList<>();
        Job job=new Job();
        job.setId(1L);
        job.setTitle("Developper");
        job.setCompany("Endava");
        job.setCity("Bucuresti");
        job.setLevel("Entry");
        job.setRequirements("asd");
        job.setDescription("asd");

        jobs.add(job);


        when(jobRepository.findAll()).thenReturn(jobs);
        List<Job> jobList=jobService.findAll();
        assertEquals(jobList.size(),1);
        verify(jobRepository,times(1)).findAll();
    }

    @Test
    @DisplayName("Find the job by id-HF")
    public void findById(){
        Job job=new Job();
        job.setId(1L);
        job.setTitle("Developper");
        job.setCompany("Endava");
        job.setCity("Bucuresti");
        job.setLevel("Entry");
        job.setRequirements("asd");
        job.setDescription("asd");


        when(jobRepository.findById(job.getId())).thenReturn(Optional.of(job));

        Optional<Job> result= Optional.ofNullable(jobService.findById(job.getId()));

        assertEquals(result.isPresent(),true);

    }

    @Test
    @DisplayName("Find the job by id-ERR")
    public void findByIdERR(){
        Job job=new Job();
        job.setId(1L);
        job.setTitle("Developper");
        job.setCompany("Endava");
        job.setCity("Bucuresti");
        job.setLevel("Entry");
        job.setRequirements("asd");
        job.setDescription("asd");

        RuntimeException result=assertThrows(RuntimeException.class,
                ()->jobService.findById(job.getId()));

        assertEquals("Job not found!",result.getMessage());


    }


    @Test
    @DisplayName("Create a new job.")
    public void newJob(){
        Job job=new Job();
        job.setId(1L);
        job.setTitle("Developper");
        job.setCompany("Endava");
        job.setCity("Bucuresti");
        job.setLevel("Entry");
        job.setRequirements("asd");
        job.setDescription("asd");

        when(jobRepository.save(job)).thenReturn(job);
        Job result=jobService.save(job);

        assertEquals(job.getId(),result.getId());
        assertEquals(job.getTitle(),result.getTitle());
        assertEquals(job.getCity(),result.getCity());
        assertEquals(job.getCompany(),result.getCompany());
        assertEquals(job.getLevel(),result.getLevel());
        assertEquals(job.getType(),result.getType());
        assertEquals(job.getRequirements(),result.getRequirements());
        assertEquals(job.getDescription(),result.getDescription());


        verify(jobRepository,times(1)).save(job);
    }

    @Test
    @DisplayName("Delete job by id")
    public void deleteById(){
        Job job=new Job();
        job.setId(1L);
        job.setTitle("Developper");
        job.setCompany("Endava");
        job.setCity("Bucuresti");
        job.setLevel("Entry");
        job.setRequirements("asd");
        job.setDescription("asd");

        when(jobRepository.findById(job.getId())).thenReturn(Optional.of(job));
        jobService.deleteById(job.getId());

        verify(jobRepository).deleteById(job.getId());

    }


    @Test
    @DisplayName("Delete job by id ERR")
    public void deleteByIdErr(){
        Job job=new Job();
        job.setId(1L);
        job.setTitle("Developper");
        job.setCompany("Endava");
        job.setCity("Bucuresti");
        job.setLevel("Entry");
        job.setRequirements("asd");
        job.setDescription("asd");

        RuntimeException result=assertThrows(RuntimeException.class,
                ()->jobService.findById(job.getId()));

        assertEquals("Job not found!",result.getMessage());

    }


}
