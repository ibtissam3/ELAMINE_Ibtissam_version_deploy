package com.example.exam.model;

import jakarta.persistence.*;

@Entity
@Table(name = "project_employee")
public class ProjectEmployee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;



    private double chargeRate; // Taux de charge sur le projet

    // Getters and setters

    public Long getId() {
        return id;
    }

    public double getChargeRate() {
        return chargeRate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public Project getProject() {
        return project;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setChargeRate(double chargeRate) {
        this.chargeRate = chargeRate;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}