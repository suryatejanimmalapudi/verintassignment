package com.verint.ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.verint.ecommerce.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
