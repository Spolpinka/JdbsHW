package model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "city")
@EqualsAndHashCode(of = "id")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id")
    private int id;

    @Column(name = "city_name")
    private String cityName;

    @OneToMany(mappedBy = "city",
            cascade = CascadeType.REMOVE, orphanRemoval = true,
            fetch = FetchType.EAGER)
    private List<Employee> employee;

    public City(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public String toString() {
        return "City{" +
                "city_id=" + id +
                ", city_name='" + cityName + '\'' +
                '}';
    }
}
