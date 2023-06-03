package dao;

import model.Employee;

import java.util.List;

public interface EmployeeDAO {

    void save(Employee employee);

    Employee findById(int id);

    void update(Employee employee);

    void delete(int id);

    List<Employee> findAll();
}
