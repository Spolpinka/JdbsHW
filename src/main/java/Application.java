import dao.CityDAO;
import dao.EmployeeDAO;
import dao.impls.CityDAOImpl;
import dao.impls.EmployeeDAOImpl;
import model.City;
import model.Employee;

public class Application {
    public static void main(String[] args) {

        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        CityDAO cityDAO = new CityDAOImpl();

        //проверка получения employee по id
        System.out.println("Получаем сотрудника по индексу 2:____________________" +
                "  \n" + employeeDAO.findById(2));

        System.out.println("Получаем город по индексу 1:____________________" +
                "  \n" + cityDAO.getCityById(1));

        //сохраняем сотрудника
        System.out.println("сохраняем сотрудника Илону Гендальфону _____________________________________");
        Employee employee = new Employee("Илона", "Гендальфова", "female", 25, 1);
        employeeDAO.save(employee);

        //сохраняем город
        System.out.println("Сохраняем город ГКН _________________________");
        City city = new City("NotExisted");
        cityDAO.save(city);

        //update сотрудника
        System.out.println("Делаем апдейт того же сотрудника в Илона Маскова ___________________________________");
        employee.setFirstName("Илон");
        employee.setLastName("Масков");
        employee.setGender("male");
        employee.setAge(39);
        employeeDAO.update(employee);

        //update city
        System.out.println("Делаем update того же city в Tbilisy __________________________________________");
        city.setCityName("Tbilisy");
        cityDAO.update(city);

        //удаляем сотрудника по ID, каждый раз новый...
        System.out.println("Удаляем сотрудника по индеклу 23 ________________________________________");
        employeeDAO.delete(23);

        //удалем город с индексом 21
        System.out.println("Удаляем город с индексом 20 (только что добавленный - 21 и дальше) _________________________");
        cityDAO.delete(cityDAO.getCityById(20));


        /*//выводим всю базу
        System.out.println("выводим всю базу_______________________________");
        for (Employee empl : employeeDAO.findAll()) {
            System.out.println(empl);
        }
        */



    }
}
