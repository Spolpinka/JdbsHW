package dao.impls;

import dao.CityDAO;
import model.City;
import org.hibernate.Session;
import utils.HibernateEmployeeSessionFactoryUtils;

import javax.persistence.Query;

public class CityDAOImpl implements CityDAO {
    @Override
    public void save(City city){
        try (Session session = HibernateEmployeeSessionFactoryUtils.getSessionFactory().openSession()){
            session.beginTransaction();
            session.save(city);
            session.getTransaction().commit();
        }
    }

    @Override
    public City getCityById(int id) {
        try (Session session = HibernateEmployeeSessionFactoryUtils.getSessionFactory().openSession()) {
            return session.get(City.class, id);
        }
    }

    @Override
    public void update(City city) {
        try (Session session = HibernateEmployeeSessionFactoryUtils.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.update(city);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(City city) {
        try (Session session = HibernateEmployeeSessionFactoryUtils.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.delete(city);
            session.getTransaction().commit();
        }
    }

}
