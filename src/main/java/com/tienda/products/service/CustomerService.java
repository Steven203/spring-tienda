package com.tienda.products.service;

import java.util.List;

import com.tienda.products.dto.CreateCustomerRequest;
import com.tienda.products.dto.CustomerResponse;
import com.tienda.products.dto.UpdateCustomerRequest;

public interface CustomerService {

    CustomerResponse create(CreateCustomerRequest request);

    List<CustomerResponse> list();

    CustomerResponse getById(Long id);

    CustomerResponse update(Long id, UpdateCustomerRequest request);

    void delete(Long id);
}
