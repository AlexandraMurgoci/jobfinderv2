package com.topspec.jobfinderv2.Domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String status;

    @ManyToOne
    private User userapp;

    @ManyToOne
    private Job jobapp;

    /*
    public void setId(Long id) {
        this.id = id;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setUserapp(User userapp) {
        this.userapp = userapp;
    }

    public void setJobapp(Job jobapp) {
        this.jobapp = jobapp;
    }

    public Long getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public User getUserapp() {
        return userapp;
    }

    public Job getJobapp() {
        return jobapp;
    }

     */
}
