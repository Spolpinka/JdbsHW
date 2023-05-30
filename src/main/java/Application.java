import dao.CityDAO;
import dao.EmployeeDAO;
import dao.impls.CityDAOImpl;
import dao.impls.EmployeeDAOImpl;
import model.Employee;

import java.sql.*;

public class Application {
    public static void main(String[] args) {

        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        CityDAO cityDAO = new CityDAOImpl();

        //проверка получения employee по id
        System.out.println("Получаем сотрудника по индексу 2:____________________" +
                "  \n" + employeeDAO.findById(2));

        System.out.println("Получаем город по индексу 1:____________________" +
                "  \n" + cityDAO.getCityById(1));

        /*//сохраняем сотрудника
        System.out.println("сохраняем сотрудника Илону Гендальфону _____________________________________");
        Employee employee = new Employee("Илона", "Гендальфова", "female", 25, 1);
        employeeDAO.save(employee);

        //update сотрудника
        System.out.println("Делаем апдейт того же сотрудника в Илона Маскова ___________________________________");
        employee.setFirst_name("Илон");
        employee.setLast_name("Масков");
        employee.setGender("male");
        employee.setAge(39);
        employeeDAO.update(employee);

        //удаляем сотрудника по ID, каждый раз новый...
        System.out.println("Удаляемем сотрудника по индеклу 23 ________________________________________");
        employeeDAO.delete(23);*/

        //выводим всю базу
        System.out.println("выводим всю базу_______________________________");
        for (Employee empl : employeeDAO.findAll()) {
            System.out.println(empl);
        }



    }
}
