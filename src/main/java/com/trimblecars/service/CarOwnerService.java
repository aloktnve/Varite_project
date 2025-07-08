package com.trimblecars.service;

import com.trimblecars.model.Car;
import com.trimblecars.model.Lease;
import com.trimblecars.repository.CarRepository;
import com.trimblecars.repository.Lease2Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class CarOwnerService {
    private static final Logger logger = LoggerFactory.getLogger(CarOwnerService.class);
    @Autowired private CarRepository carRepository;
    @Autowired private Lease2Repository leaseRepository;

    public Car registerCar(Car car) {
        logger.info("Registering car: {}", car);
        return carRepository.save(car);
    }

    public List<Car> getOwnerCars(String ownerId) {
        logger.info("Fetching cars for owner: {}", ownerId);
        return carRepository.findByOwnerId(ownerId);
    }

    public List<Lease> getLeaseHistory(String carId) {
        logger.info("Fetching lease history for car: {}", carId);
        return leaseRepository.findByCarId(carId);
    }
}
