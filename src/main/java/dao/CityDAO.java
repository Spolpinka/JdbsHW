package dao;

import model.City;

public interface CityDAO {

    void save(City city);

    City getCityById(int id);

    void update(City city);

    void delete(int id);
}
