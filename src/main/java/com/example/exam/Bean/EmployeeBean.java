package com.example.exam.Bean;

import com.example.exam.model.Employee;
import com.example.exam.service.EmployeeService;

import jakarta.annotation.ManagedBean;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@ViewScoped
public class EmployeeBean implements Serializable {
    private List<Employee> employees;
    private Employee selectedEmployee;
    private String newEmployeeName;
    private String newEmployeeEmail;

    @Inject
    private EmployeeService employeeService;

    @PostConstruct
    public void init() {
        employees = employeeService.getAllEmployees();
    }

    // Getters and setters

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public Employee getSelectedEmployee() {
        return selectedEmployee;
    }

    public void setSelectedEmployee(Employee selectedEmployee) {
        this.selectedEmployee = selectedEmployee;
    }

    public String getNewEmployeeName() {
        return newEmployeeName;
    }

    public void setNewEmployeeName(String newEmployeeName) {
        this.newEmployeeName = newEmployeeName;
    }

    public String getNewEmployeeEmail() {
        return newEmployeeEmail;
    }

    public void setNewEmployeeEmail(String newEmployeeEmail) {
        this.newEmployeeEmail = newEmployeeEmail;
    }

    // Action methods

    public void addEmployee() {
        Employee newEmployee = new Employee();
        newEmployee.setName(newEmployeeName);
        newEmployee.setEmail(newEmployeeEmail);
        employeeService.addEmployee(newEmployee);
        employees = employeeService.getAllEmployees();
        newEmployeeName = null;
        newEmployeeEmail = null;
    }

    public void deleteEmployee() {
        if (selectedEmployee != null) {
            employeeService.deleteEmployee(selectedEmployee.getId());
            employees = employeeService.getAllEmployees();
            selectedEmployee = null;
        }
    }
}
