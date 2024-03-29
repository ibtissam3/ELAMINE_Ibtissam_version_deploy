package com.example.exam.DAO;

import com.example.exam.DAO.ProjectDAO;
import com.example.exam.model.Project;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;

public class ProjectDAOImpl implements ProjectDAO {
    private EntityManagerFactory entityManagerFactory = Persistence.
            createEntityManagerFactory("myPersistenceUnit");

    @Override
    public void addProject(Project project) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(project);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void updateProject(Project project) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(project);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void deleteProject(Long projectId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Project project = entityManager.find(Project.class, projectId);
        if (project != null) {
            entityManager.remove(project);
        }
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public Project getProjectById(Long projectId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Project project = entityManager.find(Project.class, projectId);
        entityManager.close();
        return project;
    }

    @Override
    public List<Project> getAllProjects() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("SELECT p FROM Project p");
        List<Project> projects = query.getResultList();
        entityManager.close();
        return projects;
    }
}
