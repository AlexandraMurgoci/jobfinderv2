package com.topspec.jobfinderv2.service.job;

import com.topspec.jobfinderv2.model.job.Job;
import com.topspec.jobfinderv2.repository.JobRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GetJobTest {

    private final JobRepository jobRepository = mock(JobRepository.class);

    private GetJob sut;

    @Before
    public void setUp() throws Exception {
        sut =new GetJob(jobRepository);
    }

    @Test
    @DisplayName("Find the job by id-HF")
    public void findById(){
        Job job=new Job();
        job.setId(1);
        job.setTitle("Developper");
        job.setCompany("Endava");
        job.setCity("Bucuresti");
        job.setLevel("Entry");
        job.setRequirements("asd");
        job.setDescription("asd");


        when(jobRepository.findById(job.getId())).thenReturn(Optional.of(job));

        Optional<Job> result= Optional.ofNullable(sut.getById(job.getId()));

        assertEquals(result.isPresent(),true);

    }

    @Test
    @DisplayName("Find the job by id-ERR")
    public void findByIdERR(){
        Job job=new Job();
        job.setId(1);
        job.setTitle("Developper");
        job.setCompany("Endava");
        job.setCity("Bucuresti");
        job.setLevel("Entry");
        job.setRequirements("asd");
        job.setDescription("asd");

        RuntimeException result=assertThrows(RuntimeException.class,
                ()->sut.getById(job.getId()));

        assertEquals("Job not found!",result.getMessage());


    }
}
