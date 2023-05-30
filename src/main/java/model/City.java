package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.CascadeType;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "city")
@EqualsAndHashCode(of = "city_id")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int city_id;

    private String city_name;

    @OneToMany(mappedBy = "city",
            cascade = CascadeType.ALL)
    private List<Employee> employee;

    public City(String city_name) {
        this.city_name = city_name;
    }

}
