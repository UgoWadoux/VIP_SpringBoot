package com.listclient.client.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String lastName;
    private String firstName;
    private Date birthdate;
    private String licenseId;

    public Client(int id, String lastName, String firstName, Date birthdate, String licenseId) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthdate = birthdate;
        this.licenseId = licenseId;
    }

    public Client() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstNam) {
        this.firstName = firstNam;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date anniversary) {
        this.birthdate = anniversary;
    }

    public String getLicenseId() {
        return licenseId;
    }

    public void setLicenseId(String licenseNumber) {
        this.licenseId = licenseNumber;
    }
}
