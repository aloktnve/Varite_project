package com.trimblecars.controller;

import com.trimblecars.model.Car;
import com.trimblecars.model.Lease;
import com.trimblecars.service.CarOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web2.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/owner")
public class CarOwnerController {
    @Autowired private CarOwnerService carOwnerService;

    @PostMapping("/car")
    public Car registerCar(@RequestBody Car car) {
        return carOwnerService.registerCar(car);
    }

    @GetMapping("/cars/{ownerId}")
    public List<Car> getOwnerCars(@PathVariable String ownerId) {
        return carOwnerService.getOwnerCars(ownerId);
    }

    @GetMapping("/lease-history/{carId}")
    public List<Lease> getLeaseHistory(@PathVariable String carId) {
        return carOwnerService.getLease2History(carId); // NOTE: Use getLeaseHistory, not getLease2History
    }
}
