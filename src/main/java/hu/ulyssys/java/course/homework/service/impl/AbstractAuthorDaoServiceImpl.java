package hu.ulyssys.java.course.homework.service.impl;

import hu.ulyssys.java.course.homework.hibernate.entities.AbstractBlog;
import hu.ulyssys.java.course.homework.hibernate.entities.Author;
import hu.ulyssys.java.course.homework.hibernate.entities.BlogPost;
import hu.ulyssys.java.course.homework.service.AuthorDaoService;

import javax.enterprise.inject.Alternative;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractAuthorDaoServiceImpl<T extends AbstractBlog> {


    private static final String PERSISTENCE_UNIT = "AuthorPersistence";
    public EntityManager createEntityManager() {
        return Persistence.createEntityManagerFactory(PERSISTENCE_UNIT).createEntityManager();
    }

    public void save(T blogPost) {
        EntityManager entityManager = createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(blogPost);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void update(T blogPost) {
        EntityManager entityManager = createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(blogPost);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
