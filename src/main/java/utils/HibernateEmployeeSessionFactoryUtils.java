package utils;

import model.City;
import model.Employee;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateEmployeeSessionFactoryUtils {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Configuration config = new Configuration().configure("hibernate.cfg.xml");
            config.addAnnotatedClass(Employee.class);
            config.addAnnotatedClass(City.class);
            sessionFactory = config.buildSessionFactory(
                    new StandardServiceRegistryBuilder()
                            .applySettings(config.getProperties()).build());
        }
        return sessionFactory;

    }
}
