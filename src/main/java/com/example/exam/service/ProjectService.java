package com.example.exam.service;

import com.example.exam.DAO.ProjectDAO;
import com.example.exam.model.Project;

import java.util.List;

public class ProjectService {
    private ProjectDAO projectDAO;

    public ProjectService(ProjectDAO projectDAO) {
        this.projectDAO = projectDAO;
    }

    public void addProject(Project project) {
        projectDAO.addProject(project);
    }

    public void updateProject(Project project) {
        projectDAO.updateProject(project);
    }

    public void deleteProject(Long projectId) {
        projectDAO.deleteProject(projectId);
    }

    public Project getProjectById(Long projectId) {
        return projectDAO.getProjectById(projectId);
    }

    public List<Project> getAllProjects() {
        return projectDAO.getAllProjects();
    }
}
