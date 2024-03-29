package com.example.exam.DAO;

import com.example.exam.model.ProjectEmployee;

import java.util.List;

public interface ProjectEmployeeDAO {
    void addProjectEmployee(ProjectEmployee projectEmployee);
    void updateProjectEmployee(ProjectEmployee projectEmployee);
    void deleteProjectEmployee(Long projectEmployeeId);
    ProjectEmployee getProjectEmployeeById(Long projectEmployeeId);
    List<ProjectEmployee> getAllProjectEmployees();
}
