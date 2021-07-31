package hu.ulyssys.java.course.homework.hibernate;

import hu.ulyssys.java.course.homework.hibernate.entities.Author;
import hu.ulyssys.java.course.homework.hibernate.entities.BlogPost;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.Date;
import java.util.List;

public class HibernateMain {

    public static void main(String[] args) {
        //Save

        Author author = new Author();

        author.setFirstName("Robin");
        author.setLastName("Williams");
        author.setUsername("wili");
        author.setCreateDate(new Date());
        author.setLastModifiedDate(new Date());
        Long idAuthor = insertAuthor(author);
        updateAuthor(author);
        System.out.println(idAuthor);


        BlogPost blogPost = new BlogPost();
        blogPost.setTitle("cím");
        blogPost.setCategory("JAVA");
        blogPost.setCreateDate(new Date());
        blogPost.setLastModifiedDate(new Date());
        blogPost.setContent("valami");
        blogPost.setPublishedDate(new Date());
        Long idBlogPost = insertBlogPost(blogPost);
        updateBlogPost(blogPost);
        //System.out.println(id);

        Author persistAuthor = findByIdAuthor(idAuthor);
        persistAuthor.setFirstName("Teszt");
        persistAuthor.setLastName("Elek");
        persistAuthor.setUsername("Tesztelő");
        persistAuthor.setLastModifiedDate(new Date());
        updateAuthor(persistAuthor);

        BlogPost persistBlogPost = findByIdBlogPost(idBlogPost);
        persistBlogPost.setTitle("Új cím");
        persistBlogPost.setContent("valami új");
        persistBlogPost.setCategory("JAVA");
        persistBlogPost.setLastModifiedDate(new Date());
        updateBlogPost(persistBlogPost);


        findAllAuthor().forEach(author1 -> {
            System.out.println(author1.getId() + ", "+ author1.getFirstName()+" "+author1.getLastName() + ", username: "+ author1.getUsername());
            System.out.println("create date: " + author1.getCreateDate());
            System.out.println("last modified date: " + author1.getLastModifiedDate());
        });
        System.out.println();
        findAllBlogPost().forEach(blogPost1 -> {
            System.out.println(blogPost1.getId() + ", "+ blogPost1.getTitle()+", content: "+blogPost1.getContent() + ", category: "+ blogPost1.getCategory());
            System.out.println("create date: " + blogPost1.getCreateDate());
            System.out.println("last modified date: " + blogPost1.getLastModifiedDate());
            System.out.println("published date: " + blogPost1.getPublishedDate());
        });



        hu.ulyssys.java.course.homework.hibernate.DatabaseSessionProvider.getInstance().getSessionObj().close();
    }

    //author dolgai

    private static List<Author> findAllAuthor() {
        Session session = hu.ulyssys.java.course.homework.hibernate.DatabaseSessionProvider.getInstance().getSessionObj();
        Query<Author> query = session.createQuery("select n from Author n", Author.class);
        return query.getResultList();
    }

    private static Author findByIdAuthor(Long id) {
        Session session = hu.ulyssys.java.course.homework.hibernate.DatabaseSessionProvider.getInstance().getSessionObj();
        return session.find(Author.class, id);
    }
    private static void updateAuthor(Author author) {
        Session session = hu.ulyssys.java.course.homework.hibernate.DatabaseSessionProvider.getInstance().getSessionObj();
        session.beginTransaction();
        session.update(author);
        session.getTransaction().commit();
    }

    private static Long insertAuthor(Author author) {
        Session session = hu.ulyssys.java.course.homework.hibernate.DatabaseSessionProvider.getInstance().getSessionObj();
        session.beginTransaction();
        session.save(author);
        session.getTransaction().commit();
        return author.getId();
    }

    //blogPost dolgai

    private static List<BlogPost> findAllBlogPost() {
        Session session = hu.ulyssys.java.course.homework.hibernate.DatabaseSessionProvider.getInstance().getSessionObj();
        Query<BlogPost> query = session.createQuery("select n from BlogPost n", BlogPost.class);
        return query.getResultList();
    }
    private static BlogPost findByIdBlogPost(Long id) {
        Session session = hu.ulyssys.java.course.homework.hibernate.DatabaseSessionProvider.getInstance().getSessionObj();
        return session.find(BlogPost.class, id);
    }
    private static void updateBlogPost(BlogPost blogPost) {
        Session session = hu.ulyssys.java.course.homework.hibernate.DatabaseSessionProvider.getInstance().getSessionObj();
        session.beginTransaction();
        session.update(blogPost);
        session.getTransaction().commit();
    }
    private static Long insertBlogPost(BlogPost blogPost){
        Session session = hu.ulyssys.java.course.homework.hibernate.DatabaseSessionProvider.getInstance().getSessionObj();
        session.beginTransaction();
        session.save(blogPost);
        session.getTransaction().commit();
        return blogPost.getId();
    }

}