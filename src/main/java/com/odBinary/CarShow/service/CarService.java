package com.odBinary.CarShow.service;

import com.odBinary.CarShow.entity.Car;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarService {
    // get all cars
    List<Car> getCars();
    // find car by id
    Car getCarById(Long id);

    Car saveCar(Car car);

    Car updateCar(Long id, Car car);
    //del
        void deleteCar(Long id);
}