package nl.hu.iac.domain;

/**
 * Created by Nick Stuivenberg on 21-6-2017.
 */
public class Person {

    private int isEmployed;
    private String personLastName;

    public Person() {
    }

    public Person(int isEmployed, String personLastName) {
        this.isEmployed = isEmployed;
        this.personLastName = personLastName;
    }

    public int getIsEmployed() {
        return isEmployed;
    }

    public void setIsEmployed(int isEmployed) {
        this.isEmployed = isEmployed;
    }

    public String getPersonLastName() {
        return personLastName;
    }

    public void setPersonLastName(String personLastName) {
        this.personLastName = personLastName;
    }

}
