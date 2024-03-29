package com.example.exam.service;

import com.example.exam.DAO.EmployeeDAO;
import com.example.exam.DAO.EmployeeDAOImpl;
import com.example.exam.model.Employee;

import java.util.List;

public class EmployeeService {
    private EmployeeDAO employeeDAO;

    public EmployeeService() {
        // Initialisation de EmployeeDAO ici (si nécessaire)
        employeeDAO = new EmployeeDAOImpl(); // Exemple d'initialisation, remplacez par votre propre logique
    }

    public void setEmployeeDAO(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    public void addEmployee(Employee employee) {
        employeeDAO.addEmployee(employee);
    }

    public void deleteEmployee(Long employeeId) {
        employeeDAO.deleteEmployee(employeeId);
    }

    public Employee getEmployeeById(Long employeeId) {
        return employeeDAO.getEmployeeById(employeeId);
    }

    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }
}
