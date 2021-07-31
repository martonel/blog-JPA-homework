package hu.ulyssys.java.course.homework.jpa.dao;

import hu.ulyssys.java.course.homework.hibernate.entities.Author;
import hu.ulyssys.java.course.homework.hibernate.entities.BlogPost;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class BlogPostDao {
    private static final String PERSISTENCE_UNIT = "AuthorPersistence";
    private EntityManager createEntityManager() {
        return Persistence.createEntityManagerFactory(PERSISTENCE_UNIT).createEntityManager();
    }

    public void save(BlogPost blogPost) {
        EntityManager entityManager = createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(blogPost);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void update(BlogPost blogPost) {
        EntityManager entityManager = createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(blogPost);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public List<BlogPost> findAll() {
        TypedQuery<BlogPost> query = createEntityManager().createQuery("select n from BlogPost n", BlogPost.class);
        return query.getResultList();
    }

    public List<BlogPost> findByTitle(String name) {
        TypedQuery<BlogPost> query = createEntityManager().createQuery("select n from BlogPost n where n.title=:title", BlogPost.class);
        query.setParameter("title", name);
        return query.getResultList();
    }
}
