package com.topspec.jobfinderv2.Domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Setter
@Getter
@Entity
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "The title must be not blank!")
    private String title;
    @NotBlank(message = "The company name must be not blank!")
    private String company;
    @NotBlank(message = "The level must be not blank!")
    private String level;
    @NotBlank(message = "The job type must be not blank!")
    private String type;
    @NotBlank(message = "The job requirements must be not blank!")
    private String city;
    @NotBlank(message = "The city must be not blank!")
    private String requirements;
    @NotBlank(message = "The job description must be not blank!")
    private String description;

    /*
    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCompany() {
        return company;
    }

    public String getLevel() {
        return level;
    }

    public String getType() {
        return type;
    }

    public String getCity() {
        return city;
    }

    public String getRequirements() {
        return requirements;
    }

    public String getDescription() {
        return description;
    }

     */
}
