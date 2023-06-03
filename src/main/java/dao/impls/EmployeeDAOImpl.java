package dao.impls;

import dao.EmployeeDAO;
import model.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.HibernateEmployeeSessionFactoryUtils;

import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

    //получаем сотрудника по id


    @Override
    public void save(Employee employee) {
        Session session = HibernateEmployeeSessionFactoryUtils.getSessionFactory().openSession();
        try (session) {
            session.beginTransaction();
            session.save(employee);
            session.getTransaction().commit();
        }
    }

    @Override
    public Employee findById(int id) {
        try (Session session = HibernateEmployeeSessionFactoryUtils.getSessionFactory().openSession()) {
            return session.get(Employee.class, id);
        }
    }

    @Override
    public void update(Employee employee) {
        try (Session session = HibernateEmployeeSessionFactoryUtils.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.update(employee);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(int id) {
        try (Session session = HibernateEmployeeSessionFactoryUtils.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Query query = session.createNativeQuery("DELETE FROM employee WHERE id = :id");
            query.setParameter("id", id);
            query.executeUpdate();
            transaction.commit();
        }
    }

    @Override
    public List<Employee> findAll() {
        try (Session session = HibernateEmployeeSessionFactoryUtils.getSessionFactory().openSession()) {
            return session.createQuery("from Employee", Employee.class).list();
        }
    }





}
