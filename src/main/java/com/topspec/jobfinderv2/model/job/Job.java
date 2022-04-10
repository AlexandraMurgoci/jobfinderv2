package com.topspec.jobfinderv2.model.job;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@SequenceGenerator(name = "sequence_jobs", allocationSize = 1)
@Table(name = "jobs")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_jobs")
    @Column(name = "job_id")
    private Integer id;

    @Column
    @NotBlank(message = "The title must be not blank!")
    private String title;

    @Column
    @NotBlank(message = "The company name must be not blank!")
    private String company;

    @Column
    @NotBlank(message = "The level must be not blank!")
    private String level;

    @Column
    @NotBlank(message = "The job type must be not blank!")
    private String type;

    @Column
    @NotBlank(message = "The job requirements must be not blank!")
    private String city;

    @Column
    @NotBlank(message = "The city must be not blank!")
    private String requirements;

    @Column
    @NotBlank(message = "The job description must be not blank!")
    private String description;

    public Job() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
