package com.odBinary.CarShow.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@JsonIgnoreProperties("hibernateLazyInitializer")
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long ownerId;
    private String firstName, lastName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    @JsonIgnore
    private List<Car> cars;
    public Owner() {}
    public Owner(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }


    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    //
    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

//    @ManyToMany(cascade = CascadeType.PERSIST)@JoinTable(name = "car_owner",joinColumns
//            = {@JoinColumn(name = "ownerid")},inverseJoinColumns = {@JoinColumn(name = "id")
//    })
//    private Set<Car> cars = new HashSet<Car>();
//    public Set<Car> getCars(){return cars;}
//    public void setCars(Set<Car> cars){this.cars = cars;}
}