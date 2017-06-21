package nl.hu.iac.service;

import nl.hu.iac.domain.City;
import nl.hu.iac.domain.Person;
import nl.hu.iac.repositories.CityRepo;

import java.util.List;

/**
 * Created by Nick Stuivenberg on 21-6-2017.
 */
public class CityService {

    CityRepo cityRepo = new CityRepo();

    public CityService() {
    }

    public CityService(CityRepo cityRepo) {
        this.cityRepo = cityRepo;
    }

    public City addCity(City c) {
        return cityRepo.insertOneCity(c);
    }

    public City getCityByName(String cityName) {
        return cityRepo.getCityByName(cityName);
    }

    public String costPerInhabitantsCalculated(String cityName, Double d) {
        City city = getCityByName(cityName);
        int amountOfPeople = city.getListOfInhabitants().size();
        int amountNoWork = this.getAmountOfUnemployed(city.getListOfInhabitants());
        int amountWork = amountOfPeople - amountNoWork;
        double percentageNoWork = this.calculatePercentage(amountNoWork, amountOfPeople);
        double absoluteAmount = d * (double)amountNoWork;
        double perWorkingPerson = absoluteAmount / amountWork;
        String s = city.getCityName() + " has " + amountOfPeople + " inhabitants."
                + "\nOf those people, "+ amountNoWork +" are unemployed."
                + "\nThat is "+ percentageNoWork +"%"
                + "\nThis will cost the city a total of " + absoluteAmount + " currency "
                +"with an employment benefit of " + d
                + "\nThis means that each working individual has to pay " + perWorkingPerson + " curreny.";
        return s;
    }

    // Op public gezet vanwege test
    public Integer getAmountOfUnemployed(List<Person> list) {
        int counter = 0;
        for(Person p : list) {
            if(p.getIsEmployed() == 0) {
                counter++;
            }
        }
        return counter;
    }

    // Op public gezet vanwege test
    public double calculatePercentage(int noWork, int total) {
        System.out.println(noWork * 100 / total);
        return (double) (noWork * 100 / total);
    }


    public boolean hasCityWithName(String s) {
        return cityRepo.hasCityNameInList(s);
    }

    public List<City> getAllCities() {
        return null;
    }
}
