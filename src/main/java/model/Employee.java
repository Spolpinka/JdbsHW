package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String first_name;
    private String last_name;
    private String gender;
    private int age;
    private int city_id;

    public Employee(String first_name, String last_name, String gender, int age, int city_id) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.gender = gender;
        this.age = age;
        this.city_id = city_id;
    }

    @Override
    public String toString() {
        return "Сотрудник: " +
                "id=" + id + "\n" +
                "Имя - " + first_name + "\n" +
                "Фамилия - " + last_name + "\n" +
                "пол - " + gender + "\n" +
                "возраст - " + age + "\n" +
                "city_id=" + city_id;
    }
}
