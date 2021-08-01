package hu.ulyssys.java.course.homework.service.impl;

import hu.ulyssys.java.course.homework.hibernate.entities.Author;
import hu.ulyssys.java.course.homework.service.AuthorDaoService;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.persistence.TypedQuery;
import java.util.List;


@Alternative
public class AuthorDaoImpl extends AbstractAuthorDaoServiceImpl<Author> implements AuthorDaoService {
    @Override
    public List<Author> findAll(Author blog) {
        TypedQuery<Author> query = createEntityManager().createQuery("select n from Author n", Author.class);
        return query.getResultList();
    }

    @Override
    public List<Author> findByName(String name) {
        TypedQuery<Author> query = createEntityManager().createQuery("select n from Author n where n.firstName=:firstName", Author.class);
        query.setParameter("firstName", name);
        return query.getResultList();
    }


}
