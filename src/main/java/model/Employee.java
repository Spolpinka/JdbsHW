package model;

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

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String gender;
    private int age;
    //private int city_id;



    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "city_id", nullable = true)
    private City city;


    public Employee(String firstName, String lastName, String gender, int age, int city_id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.city = new CityDAOImpl().getCityById(city_id);
    }

    @Override
    public String toString() {
        return "Сотрудник: " +
                "id=" + id + "\n" +
                "Имя - " + firstName + "\n" +
                "Фамилия - " + lastName + "\n" +
                "пол - " + gender + "\n" +
                "возраст - " + age + "\n"
                //+ "city_id=" + city_id
                + "city - " + city
                ;
    }
}
