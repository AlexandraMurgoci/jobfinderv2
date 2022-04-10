package com.topspec.jobfinderv2.Domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
@Setter
@Getter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "userapp",cascade = CascadeType.ALL)
    private List<Application> applications;
/*
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setApplications(List<Application> applications) {
        this.applications = applications;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Application> getApplications() {
        return applications;
    }

     */
}
