package com.wipro.carms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.carms.entity.Car;
import com.wipro.carms.repository.CarRepository;

@Service
public class CarServiceImpl implements CarService{
	@Autowired
    private CarRepository carRepository;

    public Car saveCar(Car car) {
        return carRepository.save(car);
    }

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public Car getCarById(Long id) {
        return carRepository.findById(id).orElse(null);
    }

    public Car updateCar(Long id, Car updatedCar) {
        Car existingCar = carRepository.findById(id).orElse(null);
        if (existingCar != null) {
            existingCar.setMake(updatedCar.getMake());
            existingCar.setRegistrationDetail(updatedCar.getRegistrationDetail());
            return carRepository.save(existingCar);
        }
        return null;
    }

    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }
}
