package nl.hu.iac.repositories;

import nl.hu.iac.domain.City;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nick Stuivenberg on 21-6-2017.
 */
public class CityRepo {

    public List<City> cities = new ArrayList<>();

    public CityRepo()
    {
    }
    public City insertOneCity(City c) {
        if(!hasCityInList(c)) {
            cities.add(c);
        }
        return c;
    }

    public City getCityByName(String cityName) {
        if(this.hasCityNameInList(cityName)) {
            for(City city : cities) {
                if(city.getCityName().equals(cityName)) {
                    return city;
                }
            }
        }
        return null;
    }

    public Boolean hasCityNameInList(String cityName) {
        for(City city : cities)
        {
            if(city.getCityName().equals(cityName)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasCityInList(City c) {
        for(City city : cities)
        {
            if(city.getCityName().equals(c.getCityName())) {
                return true;
            }
        }
        return false;
    }


}
