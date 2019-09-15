package com.base.spring5webapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String lineFirst;
    private String lineSecond;
    private String zipCode;
    private String state;
    private String city;
    private String country;

    public Address() {
    }

    public Address(String zipCode, String state, String city) {
        this.zipCode = zipCode;
        this.state = state;
        this.city = city;
    }

    public Address(String lineFirst, String lineSecond, String zipCode,
                   String state, String city, String country) {
        this.lineFirst = lineFirst;
        this.lineSecond = lineSecond;
        this.zipCode = zipCode;
        this.state = state;
        this.city = city;
        this.country = country;
    }

    public String getLineFirst() {
        return lineFirst;
    }

    public void setLineFirst(String lineFirst) {
        this.lineFirst = lineFirst;
    }

    public String getLineSecond() {
        return lineSecond;
    }

    public void setLineSecond(String lineSecond) {
        this.lineSecond = lineSecond;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}