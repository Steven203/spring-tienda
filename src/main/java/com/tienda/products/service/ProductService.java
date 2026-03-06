package com.tienda.products.service;

import java.util.List;

import com.tienda.products.dto.CreateProductRequest;
import com.tienda.products.dto.UpdateProductRequest;
import com.tienda.products.dto.ProductResponse;

public interface ProductService {

    ProductResponse create(CreateProductRequest request);

    List<ProductResponse> list();

    ProductResponse getById(Long id);

    ProductResponse update(Long id, UpdateProductRequest request);

    void delete(Long id);
}