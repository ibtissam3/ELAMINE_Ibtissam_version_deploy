package com.example.exam.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double budget;

    @ManyToMany(mappedBy = "projects")
    private List<Employee> employees;

    // Getters and setters

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getBudget() {
        return budget;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public void setBudget(Double budget) {
        this.budget = budget;
    }
}