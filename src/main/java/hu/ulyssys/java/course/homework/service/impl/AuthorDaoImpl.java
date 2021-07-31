package hu.ulyssys.java.course.homework.service.impl;

import hu.ulyssys.java.course.homework.hibernate.entities.Author;
import hu.ulyssys.java.course.homework.service.AuthorDaoService;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AuthorDaoImpl  extends AbstractServiceImpl<Author> implements AuthorDaoService {

    @Override
    public void update(Author blog) {

    }
}
