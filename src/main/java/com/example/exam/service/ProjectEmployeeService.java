package com.example.exam.service;

import com.example.exam.DAO.ProjectEmployeeDAO;
import com.example.exam.model.ProjectEmployee;

import java.util.List;

public class ProjectEmployeeService {
    private ProjectEmployeeDAO projectEmployeeDAO;

    public ProjectEmployeeService(ProjectEmployeeDAO projectEmployeeDAO) {
        this.projectEmployeeDAO = projectEmployeeDAO;
    }

    public void addProjectEmployee(ProjectEmployee projectEmployee) {
        projectEmployeeDAO.addProjectEmployee(projectEmployee);
    }

    public void updateProjectEmployee(ProjectEmployee projectEmployee) {
        projectEmployeeDAO.updateProjectEmployee(projectEmployee);
    }

    public void deleteProjectEmployee(Long projectEmployeeId) {
        projectEmployeeDAO.deleteProjectEmployee(projectEmployeeId);
    }

    public ProjectEmployee getProjectEmployeeById(Long projectEmployeeId) {
        return projectEmployeeDAO.getProjectEmployeeById(projectEmployeeId);
    }

    public List<ProjectEmployee> getAllProjectEmployees() {
        return projectEmployeeDAO.getAllProjectEmployees();
    }
}
