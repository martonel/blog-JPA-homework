package hu.ulyssys.java.course.homework.jpa.dao;

import hu.ulyssys.java.course.homework.hibernate.entities.Author;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class AuthorDAO {

    private static final String PERSISTENCE_UNIT = "AuthorPersistence";
    private EntityManager createEntityManager() {
        return Persistence.createEntityManagerFactory(PERSISTENCE_UNIT).createEntityManager();
    }

    public void save(Author author) {
        EntityManager entityManager = createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(author);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void update(Author author) {
        EntityManager entityManager = createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(author);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public List<Author> findAll() {
        TypedQuery<Author> query = createEntityManager().createQuery("select n from Author n", Author.class);
        return query.getResultList();
    }

    public List<Author> findByFirstName(String name) {
        TypedQuery<Author> query = createEntityManager().createQuery("select n from Author n where n.firstName=:firstName", Author.class);
        query.setParameter("firstName", name);
        return query.getResultList();
    }
    //Delete, és findById
}