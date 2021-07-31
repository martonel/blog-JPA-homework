package hu.ulyssys.java.course.homework.service;


import hu.ulyssys.java.course.homework.hibernate.entities.AbstractBlog;

import java.util.List;

public interface CoreService<T extends AbstractBlog> {
    List<T> getAll();

    void add(T blog);

    void remove(T blog);

    void update(T blog);
}
