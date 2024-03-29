package com.example.exam.Bean;

import com.example.exam.model.Project;
import com.example.exam.service.ProjectService;

import jakarta.annotation.ManagedBean;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@ViewScoped
public class ProjectBean implements Serializable {
    private List<Project> projects;
    private Project selectedProject;
    private String newProjectName;
    private Double newProjectBudget;

    @Inject
    private ProjectService projectService;

    @PostConstruct
    public void init() {
        projects = projectService.getAllProjects();
    }

    // Getters and setters

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public Project getSelectedProject() {
        return selectedProject;
    }

    public void setSelectedProject(Project selectedProject) {
        this.selectedProject = selectedProject;
    }

    public String getNewProjectName() {
        return newProjectName;
    }

    public void setNewProjectName(String newProjectName) {
        this.newProjectName = newProjectName;
    }

    public Double getNewProjectBudget() {
        return newProjectBudget;
    }

    public void setNewProjectBudget(Double newProjectBudget) {
        this.newProjectBudget = newProjectBudget;
    }

    // Action methods

    public void addProject() {
        Project newProject = new Project();
        newProject.setName(newProjectName);
        newProject.setBudget(newProjectBudget);
        projectService.addProject(newProject);
        projects = projectService.getAllProjects();
        newProjectName = null;
        newProjectBudget = null;
    }

    public void deleteProject() {
        if (selectedProject != null) {
            projectService.deleteProject(selectedProject.getId());
            projects = projectService.getAllProjects();
            selectedProject = null;
        }
    }
}
