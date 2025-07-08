package com.trimblecars.controller;

import com.trimblecars.model.*;
import com.trimblecars.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired private AdminService adminService;

    @GetMapping("/cars")
    public List<Car> getAllCars() { return adminService.getAllCars(); }
    @GetMapping("/leases")
    public List<Lease> getAllLeases() { return adminService.getAllLeases(); }
    @GetMapping("/users")
    public List<User> getAllUsers() { return adminService.getAllUsers(); }

    @PutMapping("/car")
    public Car updateCar(@RequestBody Car2 car) { return adminService.updateCar(car); } // NOTE: Use Car, not Car2
    @PutMapping("/lease")
    public Lease updateLease(@RequestBody Lease lease) { return adminService.updateLease(lease); }
    @PutMapping("/user")
    public User updateUser(@RequestBody User user) { return adminService.updateUser(user); }

    @DeleteMapping("/car/{id}")
    public void deleteCar(@PathVariable Long id) { adminService.deleteCar(id); }
    @DeleteMapping("/lease/{id}")
    public void deleteLease(@PathVariable Long id) { adminService.deleteLease(id); }
    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable Long id) { adminService.deleteUser2(id); } // NOTE: Use deleteUser, not deleteUser2
}
