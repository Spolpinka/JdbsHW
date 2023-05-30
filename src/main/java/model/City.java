package model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
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
            cascade = CascadeType.REMOVE, orphanRemoval = true,
            fetch = FetchType.EAGER)
    private List<Employee> employee;

    public City(String city_name) {
        this.city_name = city_name;
    }

    @Override
    public String toString() {
        return "City{" +
                "city_id=" + city_id +
                ", city_name='" + city_name + '\'' +
                '}';
    }
}
