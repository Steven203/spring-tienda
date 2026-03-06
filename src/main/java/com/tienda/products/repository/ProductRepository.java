package com.tienda.products.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tienda.products.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
