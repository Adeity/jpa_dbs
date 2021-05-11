package cvut.fel.dbs.lib.zapocet;

import javax.persistence.*;

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

    private String name;

    private String surname;

    private String phoneNumber;

    private String street;

    private String city;

    private int zipcode;
//
    private int person_type_id;


    public Integer getIdperson() {
        return idperson;
    }

    public void setIdperson(Integer idperson) {
        this.idperson = idperson;
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

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }
}
