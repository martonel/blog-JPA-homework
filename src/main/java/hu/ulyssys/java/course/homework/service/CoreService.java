package hu.ulyssys.java.course.homework.service;


import hu.ulyssys.java.course.homework.hibernate.entities.AbstractBlog;

import javax.persistence.EntityManager;
import java.util.List;

public interface CoreService<T extends AbstractBlog> {

    void save(T blog);

    void update(T blog);

    List<T> findAll(T blog);

    List<T> findByName(String name);

    EntityManager createEntityManager();

}
