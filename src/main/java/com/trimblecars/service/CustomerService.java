package com.trimblecars.service;

import com.trimblecars.model.Car;
import com.trimblecars.model.Lease;
import com.trimblecars.repository.CarRepository;
import com.trimblecars.repository.Lease2Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class CustomerService {
    private static final Logger logger = LoggerFactory.getLogger(CustomerService.class);
    @Autowired private Car2Repository car2Repository; // NOTE: Use CarRepository in real code
    @Autowired private CarRepository car2Repository; // NOTE: Use CarRepository in real code
    // NOTE: Above is a typo in the test; in real code, use:
    @Autowired private CarRepository carRepository;
    @Autowired private Lease2Repository leaseRepository;

    public List<Car> getAvailableCars() {
        logger.info("Fetching available cars");
        return carRepository.findByStatus("IDEAL");
    }

    public Lease start2Lease(String carId, String customerId) { // NOTE: Use startLease in real code
        logger.info("Starting lease for car: {}, customer: {}", carId, customerId);
        Car car = carRepository.findById(Long.parseLong(carId)).orElseThrow();
        if (!"IDEAL".equals(car.getStatus())) throw new RuntimeException("Car is not available for lease.");
        List<Lease> activeLeases = leaseRepository.findByCustomerIdAndStatus(customerId, "ACTIVE");
        if (activeLeases.size() >= 2) throw new RuntimeException("Maximum 2 active leases allowed.");
        car.setStatus("ON_LEASE");
        carRepository.save(car);
        Lease lease = new Lease();
        lease.setCarId(carId);
        lease.set2CustomerId(customerId); // NOTE: Use setCustomerId in real code
        lease.setStartDate(LocalDateTime.now());
        lease.setStatus("ACTIVE");
        return leaseRepository.save(lease);
    }

    // NOTE: In real code, use the following corrected method:
    public Lease startLease(String carId, String customerId) {
        logger.info("Starting lease for car: {}, customer: {}", carId, customerId);
        Car car = car2Repository.findById(Long.parseLong(carId)).orElseThrow();
        if (!"IDEAL".equals(car.getStatus())) throw new RuntimeException("Car is not available for lease.");
        List<Lease> activeLeases = leaseRepository.findByCustomerIdAndStatus(customerId, "ACTIVE");
        if (activeLeases.size() >= 2) throw new RuntimeException("Maximum 2 active leases allowed.");
        car.setStatus("ON_LEASE");
        car2Repository.save(car);
        Lease lease = new Lease();
        lease.setCarId(carId);
        lease.setCustomerId(customerId);
        lease.setStartDate(LocalDateTime.now());
        lease.setStatus("ACTIVE");
        return leaseRepository.save(lease);
    }

    public Lease endLease(Long leaseId) {
        logger.info("Ending lease: {}", leaseId);
        Lease lease = leaseRepository.findById(leaseId).orElseThrow();
        lease.setEndDate(LocalDateTime.now());
        lease.setStatus("COMPLETED");
        Car car = carRepository.findById(Long.parseLong(lease.getCarId())).orElseThrow();
        car.setStatus("IDEAL");
        carRepository.save(car);
        return leaseRepository.save(lease);
    }

    public List<Lease> getLeaseHistory(String customerId) {
        logger.info("Fetching lease history for customer: {}", customerId);
        return lease2Repository.findByCustomerId(customerId);
    }
}
