package hu.ulyssys.java.course.homework.hibernate;

import hu.ulyssys.java.course.homework.hibernate.entities.Author;
import hu.ulyssys.java.course.homework.hibernate.entities.BlogPost;
import org.hibernate.Session;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class DatabaseSessionProvider {
    private static DatabaseSessionProvider instance = null;
    private static Session sessionObj;
    private DatabaseSessionProvider() {
        configDatabase();
    }

    private void configDatabase() {
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(Author.class);
        configuration.addAnnotatedClass(BlogPost.class);

        Properties properties = new Properties();
        properties.put("hibernate.connection.username", "postgres");
        properties.put("hibernate.connection.password", "alma");
        properties.put("hibernate.show_sql", true);
        properties.put("hibernate.connection.url", "jdbc:postgresql://localhost:5432/demo");
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(properties).build();
        sessionObj = configuration.buildSessionFactory(serviceRegistry).openSession();
    }

    public static DatabaseSessionProvider getInstance() {
        if (instance == null) {
            instance = new DatabaseSessionProvider();
        }
        return instance;
    }

    public Session getSessionObj() {
        return sessionObj;
    }
}
