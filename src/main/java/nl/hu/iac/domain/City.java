package nl.hu.iac.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nick Stuivenberg on 21-6-2017.
 */
public class City {

    private String cityName;

    private List<Person> listOfInhabitants = new ArrayList<>();

    public City() {
    }

    public City(String cityName, List<Person> listOfInhabitants) {
        this.cityName = cityName;
        this.listOfInhabitants = listOfInhabitants;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public List<Person> getListOfInhabitants() {
        return listOfInhabitants;
    }

    public void setListOfInhabitants(List<Person> listOfInhabitants) {
        this.listOfInhabitants = listOfInhabitants;
    }

    public void addPerson(Person p) {
        if(!this.hasPersonNameInList(p)) {
            listOfInhabitants.add(p);
        }
    }

    private boolean hasPersonNameInList(Person p) {
        for(Person person : listOfInhabitants)
        {
            if(person.getPersonLastName().equals(p.getPersonLastName())) {
                return true;
            }
        }
        return false;
    }


}
