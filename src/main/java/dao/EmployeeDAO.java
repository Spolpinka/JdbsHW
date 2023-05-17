package dao;

import model.Employee;

import java.util.List;

public interface EmployeeDAO {
    Employee getEmployee(int id);

    List<Employee> getAllEmployee();

    void getAllEmployeeTable();

    boolean updateEmployee(int id, Employee employee);

    boolean deleteEmployee(int id);

    boolean deleteEmployee(Employee employee);

    boolean addEmployee(String name, String surname, String email, String password, String role);

    boolean addEmployee(Employee employee);
}
