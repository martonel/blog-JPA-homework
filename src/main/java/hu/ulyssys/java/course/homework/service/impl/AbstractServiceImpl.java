package hu.ulyssys.java.course.homework.service.impl;

import hu.ulyssys.java.course.homework.hibernate.entities.AbstractBlog;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractServiceImpl<T extends AbstractBlog> {
    private List<T> list = new ArrayList<>();

    public List<T> getAll() {
        return list;
    }

    public void add(T blog) {
        list.add(blog);
    }

    public void remove(T blog) {
        list.remove(blog);
    }

}
