package cvut.fel.dbs.lib.zapocet;

import javax.persistence.*;

/**
 * Person is an entity with name, surname, phoneNumber, street, city and zipcode attribtes. Person can be teacher.
 */
@Entity
@Table(name = "person")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name = "person_type_id",
        discriminatorType = DiscriminatorType.INTEGER
)
public class Person {
    @Id
    @GeneratedValue
    public Integer idperson;

    private String pid;

    private String name;

    private String surname;

    private String phoneNumber;

    private String street;

    private String city;

    private Integer zipcode;
//
    private int person_type_id;


    public Person(String pid, String name, String surname, String phoneNumber, String street, String city, Integer zipcode, int person_type_id) {
        this.pid = pid;
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.street = street;
        this.city = city;
        this.zipcode = zipcode;
        this.person_type_id = 1;
    }

    public Person() {

    }

    public Integer getIdperson() {
        return idperson;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }


    public String getStreet() {
        return street;
    }


    public String getCity() {
        return city;
    }


    public Integer getZipcode() {
        return zipcode;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setZipcode(Integer zipcode) {
        this.zipcode = zipcode;
    }

    public String getPid() {
        return pid;
    }

}
