package com.example.exam.DAO;

import com.example.exam.model.Project;

import java.util.List;

public interface ProjectDAO {
    void addProject(Project project);
    void updateProject(Project project);
    void deleteProject(Long projectId);
    Project getProjectById(Long projectId);
    List<Project> getAllProjects();
}
