package hu.ulyssys.java.course.homework.jpa;

import hu.ulyssys.java.course.homework.hibernate.entities.Author;
import hu.ulyssys.java.course.homework.hibernate.entities.BlogPost;
import hu.ulyssys.java.course.homework.jpa.dao.AuthorDAO;
import hu.ulyssys.java.course.homework.jpa.dao.BlogPostDao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.Date;

public class JPAMain {
    public static void main(String[] args) {

        AuthorDAO authorDAO = new AuthorDAO();
        Author author = new Author();
        author.setFirstName("Borza");
        author.setLastName("Márton");
        author.setUsername("marci");
        author.setCreateDate(new Date());
        author.setLastModifiedDate(new Date());
        authorDAO.save(author);

        authorDAO.findAll().forEach(author1 -> {
            System.out.println(author1.getId() + "\n"+ author1.getFirstName()+" "+author1.getLastName() + ", username: "+ author1.getUsername());
            System.out.println("create date: " + author1.getCreateDate());
            System.out.println("last modified date: " + author1.getLastModifiedDate());
        });

        BlogPostDao blogPostDao = new BlogPostDao();
        BlogPost blogPost = new BlogPost();
        blogPost.setTitle("Programozás alapjai");
        blogPost.setCategory("JAVA");
        blogPost.setCreateDate(new Date());
        blogPost.setLastModifiedDate(new Date());
        blogPost.setContent("hogyan programozzunk");
        blogPost.setPublishedDate(new Date());
        blogPostDao.save(blogPost);


        blogPostDao.findAll().forEach(blogPost1 -> {
            System.out.println(blogPost1.getId() + "\n"+ blogPost1.getTitle()+", content: "+blogPost1.getContent() + ", category: "+ blogPost1.getCategory());
            System.out.println("create date: " + blogPost1.getCreateDate());
            System.out.println("last modified date: " + blogPost1.getLastModifiedDate());
            System.out.println("published date: " + blogPost1.getPublishedDate());
        });
    }

}
