package com.tienda.products.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tienda.products.dto.CreateCustomerRequest;
import com.tienda.products.dto.CustomerResponse;
import com.tienda.products.dto.UpdateCustomerRequest;
import com.tienda.products.entity.Customer;
import com.tienda.products.exception.DuplicateEmailException;
import com.tienda.products.exception.ResourceNotFoundException;
import com.tienda.products.repository.CustomerRepository;
import com.tienda.products.service.CustomerService;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;

    public CustomerServiceImpl(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public CustomerResponse create(CreateCustomerRequest request) {
        if (repository.existsByEmail(request.getEmail())) {
            throw new DuplicateEmailException("Email already registered: " + request.getEmail());
        }
        Customer customer = new Customer();
        customer.setFullName(request.getFullName());
        customer.setEmail(request.getEmail());
        customer.setPhone(request.getPhone());
        return toResponse(repository.save(customer));
    }

    @Override
    @Transactional(readOnly = true)
    public List<CustomerResponse> list() {
        return repository.findAll().stream().map(this::toResponse).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public CustomerResponse getById(Long id) {
        return toResponse(findOrThrow(id));
    }

    @Override
    public CustomerResponse update(Long id, UpdateCustomerRequest request) {
        Customer customer = findOrThrow(id);

        // Allow same email for the same customer, but block if another customer has it
        if (!customer.getEmail().equalsIgnoreCase(request.getEmail())
                && repository.existsByEmail(request.getEmail())) {
            throw new DuplicateEmailException("Email already registered: " + request.getEmail());
        }

        customer.setFullName(request.getFullName());
        customer.setEmail(request.getEmail());
        customer.setPhone(request.getPhone());
        return toResponse(repository.save(customer));
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Customer " + id + " not found");
        }
        repository.deleteById(id);
    }

    // ── helpers ──────────────────────────────────────────────────────────────

    private Customer findOrThrow(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer " + id + " not found"));
    }

    private CustomerResponse toResponse(Customer c) {
        CustomerResponse r = new CustomerResponse();
        r.setId(c.getId());
        r.setFullName(c.getFullName());
        r.setEmail(c.getEmail());
        r.setPhone(c.getPhone());
        r.setCreatedAt(c.getCreatedAt());
        return r;
    }
}
