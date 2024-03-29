package com.example.exam.model;

import com.example.exam.model.Project;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    @ElementCollection
    private List<String> skills;

    @ManyToMany
    @JoinTable(name = "project_employee",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "project_id"))
    private List<Project> projects;
    @Enumerated(EnumType.STRING)
    private Post post;


    // Getters and setters


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public List<String> getSkills() {
        return skills;
    }

    public Post getPost() {
        return post;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }


    public enum Post {
    MANAGER,
    DEV,
    TEST,
    DEVOPS,
    TECH_LEAD
}
}