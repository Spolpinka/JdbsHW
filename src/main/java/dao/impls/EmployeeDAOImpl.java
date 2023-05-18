package dao.impls;

import dao.EmployeeDAO;
import model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

    private final String password = "421243266";
    private final String user = "postgres";
    private final String driver = "org.postgresql.Driver";
    private final String url = "jdbc:postgresql://localhost:5432/skypro";

    //получаем сотрудника по id
    @Override
    public Employee getEmployee(int id) {
        try (final Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM employee WHERE id = (?)")) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            Employee employee;
            resultSet.next();
            employee = new Employee(resultSet.getInt("id"),
                    resultSet.getString("first_name"),
                    resultSet.getString("last_name"),
                    resultSet.getString("gender"),
                    resultSet.getInt("age"),
                    resultSet.getInt("city_id"));


            return employee;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //получаем всех сотрудников
    @Override
    public List<Employee> getAllEmployee() {
        List<Employee> result = new ArrayList<>();
        try (final Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM employee")) {
            statement.getMaxRows();

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                result.add(new Employee(resultSet.getInt("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("gender"),
                        resultSet.getInt("age"),
                        resultSet.getInt("city_id")));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    @Override
    public void getAllEmployeeTable() {
        final int width = 20;//ширина столбца
        try (final Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM employee ORDER BY id")) {
            statement.getMaxRows();

            ResultSet resultSet = statement.executeQuery();
            System.out.println("| id  | @first_name        | @last_name         | @gender           " +
                    "| @age               | @city_id            |");
            while (resultSet.next()) {
                StringBuilder sb = new StringBuilder();
                sb.append("|")
                        .append(resultSet.getInt("id"))
                        .append("    | ")
                        .append(resultSet.getString("first_name"));
                for (int i = 0; i < width - resultSet.getString("first_name").length() - 1; i++) {
                    sb.append(" ");
                }
                sb.append("| ")
                        .append(resultSet.getString("last_name"));
                for (int i = 0; i < width - resultSet.getString("last_name").length() - 1; i++) {
                    sb.append(" ");
                }
                sb.append("|").append(resultSet.getString("gender"));
                for (int i = 0; i < width - resultSet.getString("gender").length() - 1; i++) {
                    sb.append(" ");
                }
                sb.append("| ")
                        .append(resultSet.getInt("age"));
                for (int i = 0; i < width - resultSet.getString("age").length() - 1; i++) {
                    sb.append(" ");
                }
                sb.append("| ")
                        .append(resultSet.getInt("city_id"));
                for (int i = 0; i < width - resultSet.getString("city_id").length() - 1; i++) {
                    sb.append(" ");
                }

                System.out.println(sb);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //обновляем сотрудника в базе данных
    @Override
    public boolean updateEmployee(int id, Employee employee) {
        try (final Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement(
                     "UPDATE employee " +
                             "SET first_name='" + employee.getFirst_name() +
                             "', last_name='" + employee.getLast_name() +
                             "' WHERE id = (?)")) {
            statement.setInt(1, id);
            statement.execute();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    //удаляем сотрудника
    @Override
    public boolean deleteEmployee(int id) {

        try (final Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement("DELETE FROM employee WHERE id = (?)")) {
            statement.setInt(1, id);
            statement.executeUpdate();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    @Override
    public boolean deleteEmployee(Employee employee) {


        return false;
    }


    // добавляем сотрудника
    @Override
    public boolean addEmployee(Employee employee) {
        try (final Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement(
                     "INSERT INTO employee (first_name, last_name, gender, age, city_id) " +
                             "VALUES (?, ?, ?, ?, ?)")) {
            statement.setString(1, employee.getFirst_name());
            statement.setString(2, employee.getLast_name());
            statement.setString(3, employee.getGender());
            statement.setInt(4, employee.getAge());
            statement.setInt(5, employee.getCity_id());
            statement.executeUpdate();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    @Override
    public boolean addEmployee(String firstName, String lastName, String gender, int age, int cityId) {


        return false;
    }


}
