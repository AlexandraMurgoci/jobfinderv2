package com.topspec.jobfinderv2.service.job;

import com.topspec.jobfinderv2.model.job.Job;
import com.topspec.jobfinderv2.repository.JobRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class DeleteJobTest {

    private final JobRepository jobRepository = mock(JobRepository.class);

    private DeleteJob sut;

    @Before
    public void setUp() throws Exception {
        sut =new DeleteJob(jobRepository);
    }

    @Test
    @DisplayName("Delete job by id")
    public void deleteById(){
        Job job=new Job();
        job.setId(1);
        job.setTitle("Developper");
        job.setCompany("Endava");
        job.setCity("Bucuresti");
        job.setLevel("Entry");
        job.setRequirements("asd");
        job.setDescription("asd");

        when(jobRepository.findById(job.getId())).thenReturn(Optional.of(job));
        sut.byId(job.getId());

        verify(jobRepository).deleteById(job.getId());

    }


    @Test
    @DisplayName("Delete job by id ERR")
    public void deleteByIdErr(){
        Job job=new Job();
        job.setId(1);
        job.setTitle("Developper");
        job.setCompany("Endava");
        job.setCity("Bucuresti");
        job.setLevel("Entry");
        job.setRequirements("asd");
        job.setDescription("asd");

        RuntimeException result=assertThrows(RuntimeException.class,
                ()->sut.byId(job.getId()));

        assertEquals("Job not found!",result.getMessage());

    }
}
