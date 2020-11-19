package com.residwi.microservice.customer.service.impl;

import com.residwi.microservice.customer.dto.CustomerDto;
import com.residwi.microservice.customer.handler.NotFoundException;
import com.residwi.microservice.customer.entity.Customer;
import com.residwi.microservice.customer.repository.CustomerRepository;
import com.residwi.microservice.customer.request.CreateCustomerRequest;
import com.residwi.microservice.customer.request.UpdateCustomerRequest;
import com.residwi.microservice.customer.service.CustomerService;
import com.residwi.microservice.customer.service.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public CustomerDto create(CreateCustomerRequest createCustomerRequest) {
        Customer customer = customerRepository.save(customerMapper.toEntity(createCustomerRequest));
        return customerMapper.toDTO(customer);
    }

    @Override
    public CustomerDto update(Long id, UpdateCustomerRequest updateCustomerRequest) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(NotFoundException::new);

        Customer customerUpdated = customerRepository.save(customerMapper.toEntity(updateCustomerRequest, customer));
        return customerMapper.toDTO(customerUpdated);
    }

    @Override
    public CustomerDto get(Long id) {
        Customer customer = findCustomerByIdOrThrowNotFound(id);

        return customerMapper.toDTO(customer);
    }

    @Override
    public List<CustomerDto> list() {
        List<Customer> customers = customerRepository.findAll();

        return customerMapper.toDTOs(customers);
    }

    private Customer findCustomerByIdOrThrowNotFound(Long id) {
        return customerRepository.findById(id).orElseThrow(NotFoundException::new);
    }

}
