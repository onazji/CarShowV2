package com.odBinary.CarShow.service;
import com.odBinary.CarShow.entity.Car;
import com.odBinary.CarShow.exception.ResourceNotFoundException;
import com.odBinary.CarShow.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private CarRepository carRepository;

    @Override
    public List<Car> getCars() {
        return (List<Car>) carRepository.findAll();// find all return iterable so we need to cast it to List type.
    }

    @Override
    public Car getCarById(Long id) {
        Optional<Car> optionalCar = carRepository.findById(id);
        if (optionalCar.isPresent()) {
            return optionalCar.get();
        } else {
            throw new ResourceNotFoundException("Oops! Car with " + id + " not found in the database");
        }

    }

    @Override
    public Car saveCar(Car car) {
        return carRepository.save(car);
    }

    @Override
    public Car updateCar(Long id, Car car) {
        Optional<Car> optionalCar = carRepository.findById(id);
        if (optionalCar.isPresent()) {
//            optionalCar.get().setId(car.getId());
            optionalCar.get().setBrand(car.getBrand());
            optionalCar.get().setModel(car.getModel());
            optionalCar.get().setColor(car.getColor());
            optionalCar.get().setPrice(car.getPrice());
            optionalCar.get().setYear(car.getYear());
            optionalCar.get().setOwner(car.getOwner());
            carRepository.save(optionalCar.get());
            return optionalCar.get();
        } else {
            throw new ResourceNotFoundException("Car with" + id + " does not exist");
        }

    }

    @Override
    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }
}