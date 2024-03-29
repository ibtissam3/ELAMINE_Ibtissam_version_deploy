package com.example.exam.Bean;

import com.example.exam.model.Employee;
import com.example.exam.model.Project;
import com.example.exam.model.ProjectEmployee;
import com.example.exam.service.EmployeeService;
import com.example.exam.service.ProjectEmployeeService;
import com.example.exam.service.ProjectService;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class ProjectEmployeeBean implements Serializable {
    private List<ProjectEmployee> projectEmployees;
    private ProjectEmployee selectedProjectEmployee;
    private Employee selectedEmployee;
    private Project selectedProject;
    private Double chargeRate;

    @Inject
    private ProjectEmployeeService projectEmployeeService;

    @Inject
    private EmployeeService employeeService;

    @Inject
    private ProjectService projectService;

    @PostConstruct
    public void init() {
        projectEmployees = projectEmployeeService.getAllProjectEmployees();
    }

    // Getters and setters

    public List<ProjectEmployee> getProjectEmployees() {
        return projectEmployees;
    }

    public void setProjectEmployees(List<ProjectEmployee> projectEmployees) {
        this.projectEmployees = projectEmployees;
    }

    public ProjectEmployee getSelectedProjectEmployee() {
        return selectedProjectEmployee;
    }

    public void setSelectedProjectEmployee(ProjectEmployee selectedProjectEmployee) {
        this.selectedProjectEmployee = selectedProjectEmployee;
    }

    public Employee getSelectedEmployee() {
        return selectedEmployee;
    }

    public void setSelectedEmployee(Employee selectedEmployee) {
        this.selectedEmployee = selectedEmployee;
    }

    public Project getSelectedProject() {
        return selectedProject;
    }

    public void setSelectedProject(Project selectedProject) {
        this.selectedProject = selectedProject;
    }

    public Double getChargeRate() {
        return chargeRate;
    }

    public void setChargeRate(Double chargeRate) {
        this.chargeRate = chargeRate;
    }

    // Action methods

    public void addProjectEmployee() {
        ProjectEmployee newProjectEmployee = new ProjectEmployee();
        newProjectEmployee.setEmployee(selectedEmployee);
        newProjectEmployee.setProject(selectedProject);
        newProjectEmployee.setChargeRate(chargeRate);
        projectEmployeeService.addProjectEmployee(newProjectEmployee);
        projectEmployees = projectEmployeeService.getAllProjectEmployees();
        selectedEmployee = null;
        selectedProject = null;
        chargeRate = null;
    }

    public void deleteProjectEmployee() {
        if (selectedProjectEmployee != null) {
            projectEmployeeService.deleteProjectEmployee(selectedProjectEmployee.getId());
            projectEmployees = projectEmployeeService.getAllProjectEmployees();
            selectedProjectEmployee = null;
        }
    }
}
