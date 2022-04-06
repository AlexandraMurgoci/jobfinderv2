package com.topspec.jobfinderv2.service.job;

import com.topspec.jobfinderv2.model.job.Job;
import com.topspec.jobfinderv2.repository.JobRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CreateOrUpdateJobTest {

    private final JobRepository jobRepository = mock(JobRepository.class);

    private CreateOrUpdateJob sut;

    @Before
    public void setUp() throws Exception {
        sut =new CreateOrUpdateJob(jobRepository);
    }

    @Test
    @DisplayName("Create a new job.")
    public void newJob(){
        Job job=new Job();
        job.setId(1);
        job.setTitle("Developper");
        job.setCompany("Endava");
        job.setCity("Bucuresti");
        job.setLevel("Entry");
        job.setRequirements("asd");
        job.setDescription("asd");

        when(jobRepository.save(job)).thenReturn(job);
        Job result=sut.save(job);

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
}
