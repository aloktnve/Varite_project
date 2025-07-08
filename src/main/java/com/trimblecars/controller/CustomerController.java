package com.trimblecars.controller;

import com.trimblecars.model.Car;
import com.trimblecars.model.Lease;
import com.trimblecars.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired private CustomerService customerService;

    @GetMapping("/cars")
    public List<Car> getAvailableCars() {
        return customerService.getAvailableCars();
    }

    @PostMapping("/lease/start")
    public Lease startLease(@RequestParam String carId, @RequestParam String customerId) {
        return customerService.startLease(carId, customerId);
    }

    @PostMapping("/lease/end/{id}")
    public Lease endLease(@PathVariable Long id) {
        return customerService.endLease(id);
    }

    @GetMapping("/lease-history/{customerId}")
    public List<Lease> getLeaseHistory(@PathVariable String customerId) {
        return customerService.getLeaseHistory(customerId);
    }
}
