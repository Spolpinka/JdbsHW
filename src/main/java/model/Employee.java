package model;

import dao.CityDAO;
import dao.impls.CityDAOImpl;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "employee")
@EqualsAndHashCode(of = "id")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String first_name;
    private String last_name;
    private String gender;
    private int age;
    //private int city_id;



    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "city_id", nullable = true)
    private City city;


    public Employee(String first_name, String last_name, String gender, int age, int city_id) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.gender = gender;
        this.age = age;
        this.city = new CityDAOImpl().getCityById(city_id);
    }

    @Override
    public String toString() {
        return "Сотрудник: " +
                "id=" + id + "\n" +
                "Имя - " + first_name + "\n" +
                "Фамилия - " + last_name + "\n" +
                "пол - " + gender + "\n" +
                "возраст - " + age + "\n"
                //+ "city_id=" + city_id
                + "city - " + city
                ;
    }
}
