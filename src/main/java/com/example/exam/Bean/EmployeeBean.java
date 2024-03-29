package com.example.exam.Bean;

import com.example.exam.DAO.EmployeeDAO;
import com.example.exam.model.Employee;
import com.example.exam.service.EmployeeService;

import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.ViewScoped;

import java.util.List;

@ManagedBean
@ViewScoped
public class EmployeeBean {
    private EmployeeService employeeService;

    public EmployeeBean() {
        // Initialisez EmployeeService
        employeeService = new EmployeeService();
    }

    public List<Employee> getAllEmployees() {
        // Utilisez la méthode de service pour obtenir tous les employés
        return employeeService.getAllEmployees();
    }

    // Autres méthodes et fonctionnalités de la classe EmployeeBean
}
