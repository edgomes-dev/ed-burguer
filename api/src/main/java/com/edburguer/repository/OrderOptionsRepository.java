package com.edburguer.repository;

import com.edburguer.entity.OrderOptions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderOptionsRepository extends JpaRepository<OrderOptions, Long> {
}
