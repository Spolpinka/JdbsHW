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

    boolean addEmployee(Employee employee);

    boolean addEmployee(String firstName, String lastName, String gender, int age, int cityId);
}
