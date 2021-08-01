package hu.ulyssys.java.course.homework.service;

import hu.ulyssys.java.course.homework.hibernate.entities.Author;

import javax.enterprise.inject.spi.CDI;
import javax.inject.Inject;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


public class CDIMain {

    @Inject
    private AuthorDaoService authorDaoService;


    public static void main(String[] args) {
        CDI<Object> cdi = CDI.getCDIProvider().initialize();
        CDIMain main = cdi.select(CDIMain.class).get();
        main.main(Arrays.asList(args));
    }

    protected void main(List<String> args) {
        authorDaoService.createEntityManager();

        Author author = new Author();
        author.setFirstName("Borza");
        author.setLastName("Márton");
        author.setUsername("marci");
        author.setCreateDate(new Date());
        author.setLastModifiedDate(new Date());
        authorDaoService.save(author);

        authorDaoService.findAll(author).forEach(author1 -> {
            System.out.println(author1.getId() + ", "+ author1.getFirstName()+" "+author1.getLastName() + ", username: "+ author1.getUsername());
            System.out.println("create date: " + author1.getCreateDate());
            System.out.println("last modified date: " + author1.getLastModifiedDate());
        });
    }
}
