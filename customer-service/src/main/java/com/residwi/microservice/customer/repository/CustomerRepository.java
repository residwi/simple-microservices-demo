package com.residwi.microservice.customer.repository;

import com.residwi.microservice.customer.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
