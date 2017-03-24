package util;

import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.io.IOException;

public class ConnectionHibe implements ConnectionI {
    private static SessionFactory sessionFactory;

    @SuppressWarnings("UnusedDeclaration")
    public static synchronized SessionFactory getSessionFactory() throws IOException {
        if (sessionFactory == null) {
            Configuration cnf = new Configuration();
            cnf.addAnnotatedClass(User.class);
            cnf.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
            cnf.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
            cnf.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/testgerman1");
            cnf.setProperty("hibernate.connection.username", "root");
            cnf.setProperty("hibernate.connection.password", "root");
            cnf.setProperty("hibernate.show_sql", "true");
            cnf.setProperty("hibernate.hbm2ddl.auto","update");
            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
            builder.applySettings(cnf.getProperties());
            ServiceRegistry serviceRegistry = builder.build();
            sessionFactory = cnf.buildSessionFactory(serviceRegistry);
            return sessionFactory;
        }
        return sessionFactory;
    }
    @SuppressWarnings("UnusedDeclaration")
    public static Session getSession() throws IOException {
        return getSessionFactory().openSession();
    }

    @Override
    public String getIngoConnection() {
        String str = "Connection successfully";
        return str;
    }
}
