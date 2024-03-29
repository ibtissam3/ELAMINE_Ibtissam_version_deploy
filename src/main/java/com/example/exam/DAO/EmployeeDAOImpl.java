package com.example.exam.DAO;

import com.example.exam.DAO.EmployeeDAO;

import com.example.exam.model.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    private EntityManagerFactory entityManagerFactory = Persistence
            .createEntityManagerFactory("myPersistenceUnit");


    @Override
    public void addEmployee(Employee employee) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(employee);
        entityManager.getTransaction().commit();
        entityManager.close();
    }



    @Override
    public void deleteEmployee(Long employeeId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Employee employee = entityManager.find(Employee.class, employeeId);
        if (employee != null) {
            entityManager.remove(employee);
        }
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public Employee getEmployeeById(Long employeeId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Employee employee = entityManager.find(Employee.class, employeeId);
        entityManager.close();
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("SELECT e FROM Employee e");
        List<Employee> employees = query.getResultList();
        entityManager.close();
        return employees;
    }

    // Implement other methods similar to addEmployee
}
