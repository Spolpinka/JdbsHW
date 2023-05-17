import dao.EmployeeDAO;
import dao.impls.EmployeeDAOImpl;
import model.Employee;

import javax.sound.midi.Soundbank;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        final String password = "421243266";
        final String user = "postgres";
        final String url = "jdbc:postgresql://localhost:5432/skypro";
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();

        try (final Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM employee WHERE id = (?)"))
        {
            statement.setInt(1, 1);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                System.out.println("Имя :       " + resultSet.getString("first_name"));
                System.out.println("Фамилия :   " + resultSet.getString("last_name"));
                System.out.println("Пол :       " + resultSet.getString("gender"));

                System.out.println("Возраст :   " + resultSet.getInt("age"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        //проверка получения employee по id
        System.out.println("Получаем сотрудника по индексу 2:  \n" + employeeDAO.getEmployee(2));

        //проверка получения всех employee
        System.out.println("Получаем всех сотрудников:");
        employeeDAO.getAllEmployeeTable();

        //проверка добавления employee
        Employee employee = new Employee("Илон", "Маск", "male", 25, 1);
        System.out.println("Сотрудник Илон Гендальфович Маск " + (employeeDAO.addEmployee(employee) ? "добавлен" : "не добавлен"));
        //System.out.println(employeeDAO.getAllEmployee().toString());

        //проверка удаления employee
        System.out.println("Сотрудника Илона Маскова удален " + (employeeDAO.deleteEmployee(13) ? "удален" : "не удален"));
        //System.out.println(employeeDAO.getAllEmployee().toString());

        //проверка обновления employee
        System.out.println("Сотрудник с id = 1 обновлен до Илона Гендальфовича " +
                ((employeeDAO.updateEmployee(1, employee)) ? "успешно" : "безуспешно"));
        //System.out.println(employeeDAO.getAllEmployee().toString());

        employeeDAO.getAllEmployeeTable();


    }
}
