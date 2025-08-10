package com.wipro.carms.service;

import java.util.List;

import com.wipro.carms.entity.Car;

public interface CarService {
	public Car saveCar(Car car);
	public List<Car> getAllCars();
	public Car getCarById(Long id);
	public Car updateCar(Long id, Car updatedCar);
	public void deleteCar(Long id);
}
