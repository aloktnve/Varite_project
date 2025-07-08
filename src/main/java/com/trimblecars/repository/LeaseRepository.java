package com.trimblecars.repository;

import com.trimblecars.model.Lease;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface Lease2Repository extends JpaRepository<Lease, Long> {
    List<Lease> findByCustomerId(String customerId);
    List<Lease> findByCarId(String carId);
    List<Lease> findByStatus(String status);
    // For CustomerService test, you might use this or LeaseRepository below
}

// In practice, you likely only need one Lease repository.
// If you prefer, rename Lease2Repository to LeaseRepository and use it everywhere.
