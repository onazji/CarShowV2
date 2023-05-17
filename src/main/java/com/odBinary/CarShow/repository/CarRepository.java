package com.odBinary.CarShow.repository;

import com.odBinary.CarShow.entity.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CarRepository extends CrudRepository<Car,Long> {
    //fetch car by brand
    List<Car> findCarByBrand(String brand);
    //fetch car by color
    List<Car>findCarByColor(String color);
    //fetch car by year
    List<Car> findCarByYear(int year);
    //fetch car by color and Model
    List<Car> findCarByBrandAndModel(String brand,String model);
    //fetch car by year and sort by year
    List<Car> findCarByBrandOrderByYearAsc(String brand);

}