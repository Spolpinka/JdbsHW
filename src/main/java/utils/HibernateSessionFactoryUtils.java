package utils;

import model.Employee;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactoryUtils {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Configuration config = new Configuration().configure("hibernate.cfg.xml");
            config.addAnnotatedClass(Employee.class);
            sessionFactory = config.buildSessionFactory(
                    new StandardServiceRegistryBuilder()
                            .applySettings(config.getProperties()).build());
        }
        return sessionFactory;

    }
}
