package com.topspec.jobfinderv2.Repository;

import com.example.jobf.Domain.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationRepository extends JpaRepository<Application,Long> {
    List<Application> findByUserapp_Id(long id);
}
