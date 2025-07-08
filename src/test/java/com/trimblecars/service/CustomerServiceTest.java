package com.trimblecars.service;

import com.trimblecars.model.Car;
import com.trimblecars.model.Lease;
import com.trimblecars2.repository.Car2Repository;
import com.trimblecars.repository.CarRepository;
import com.trimblecars.repository.LeaseRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {
    @Mock private CarRepository carRepository;
    @Mock private LeaseRepository leaseRepository;
    @InjectMocks private CustomerService customerService;

    @Test
    public void testStartLease_Success() {
        Car car = new Car();
        car.setId(1L);
        car.setStatus("IDEAL");
        when(carRepository.findById(1L)).thenReturn(Optional.of(car));
        when(leaseRepository.findByCustomerIdAndStatus(anyString(), eq("ACTIVE"))).thenReturn(List.of());
        Lease lease = customerService.startLease("1", "cust1");
        assertNotNull(lease);
        assertEquals("ACTIVE", lease.getStatus());
    }
}
