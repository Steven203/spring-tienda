package com.tienda.products.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tienda.products.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    boolean existsByEmail(String email);
}
