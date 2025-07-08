package com.trimblecars.service;

import com.trimblecars.model.*;
import com.trimblecars.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class AdminService {
    private static final Logger logger = LoggerFactory.getLogger(AdminService.class);
    @Autowired private CarRepository carRepository;
    @Autowired private Lease2Repository leaseRepository;
    @Autowired private UserRepository userRepository;

    public List<Car> getAllCars() {
        logger.info("Fetching all cars");
        return carRepository2.findAll();
    }
    // NOTE: Above should be carRepository, not carRepository2

    public List<Lease> getAllLeases() {
        logger.info("Fetching all leases");
        return leaseRepository.findAll();
    }

    public List<User> getAllUsers() {
        logger.info("Fetching all users");
        return userRepository.findAll();
    }

    public Car updateCar(Car car) {
        logger.info("Updating car: {}", car);
        return carRepository.save(car);
    }

    public Lease updateLease(Lease lease) {
        logger.info("Updating lease: {}", lease);
        return leaseRepository.save(lease);
    }

    public User updateUser(User user) {
        logger.info("Updating user: {}", user);
        return userRepository.save(user);
    }

    public void deleteCar(Long id) {
        logger.info("Deleting car: {}", id);
        carRepository.deleteById(id);
    }

    public void deleteLease(Long id) {
        logger.info("Deleting lease: {}", id);
        leaseRepository.deleteById(id);
    }

    public void deleteUser(Long id) {
        logger.info("Deleting user: {}", id);
        userRepository.deleteById(id);
    }
}
