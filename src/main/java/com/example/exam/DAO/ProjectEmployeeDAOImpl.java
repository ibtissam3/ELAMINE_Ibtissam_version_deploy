package com.example.exam.DAO;

import com.example.exam.model.ProjectEmployee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;

public class ProjectEmployeeDAOImpl implements ProjectEmployeeDAO {
    private EntityManagerFactory entityManagerFactory = Persistence.
            createEntityManagerFactory("myPersistenceUnit");

    @Override
    public void addProjectEmployee(ProjectEmployee projectEmployee) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(projectEmployee);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void updateProjectEmployee(ProjectEmployee projectEmployee) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(projectEmployee);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void deleteProjectEmployee(Long projectEmployeeId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        ProjectEmployee projectEmployee = entityManager.find(ProjectEmployee.class, projectEmployeeId);
        if (projectEmployee != null) {
            entityManager.remove(projectEmployee);
        }
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public ProjectEmployee getProjectEmployeeById(Long projectEmployeeId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        ProjectEmployee projectEmployee = entityManager.find(ProjectEmployee.class, projectEmployeeId);
        entityManager.close();
        return projectEmployee;
    }

    @Override
    public List<ProjectEmployee> getAllProjectEmployees() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("SELECT pe FROM ProjectEmployee pe");
        List<ProjectEmployee> projectEmployees = query.getResultList();
        entityManager.close();
        return projectEmployees;
    }
}
