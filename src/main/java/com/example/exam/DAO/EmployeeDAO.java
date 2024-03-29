package com.example.exam.DAO;

import com.example.exam.model.Employee;

import java.util.List;

public interface EmployeeDAO {
    void addEmployee(Employee employee);
    //void updateEmployee(Employee employee);
    void deleteEmployee(Long employeeId);
    Employee getEmployeeById(Long employeeId);
    List<Employee> getAllEmployees();
}
