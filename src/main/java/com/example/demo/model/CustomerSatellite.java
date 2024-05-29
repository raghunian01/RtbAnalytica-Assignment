package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class CustomerSatellite {

    @Id
    private Long id;
    private String name;
    private String country;
    private String launcherId;
    private Double mass;
    private java.util.Date launchDate;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLauncherId() {
        return launcherId;
    }

    public void setLauncherId(String launcherId) {
        this.launcherId = launcherId;
    }

    public Double getMass() {
        return mass;
    }

    public void setMass(Double mass) {
        this.mass = mass;
    }

    public java.util.Date getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(java.util.Date launchDate) {
        this.launchDate = launchDate;
    }
}
