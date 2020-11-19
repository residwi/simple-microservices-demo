package com.residwi.microservice.customer.service;

import com.residwi.microservice.customer.dto.CustomerDto;
import com.residwi.microservice.customer.request.CreateCustomerRequest;
import com.residwi.microservice.customer.request.UpdateCustomerRequest;

import java.util.List;

public interface CustomerService {

    CustomerDto create(CreateCustomerRequest createCustomerRequest);

    CustomerDto update(Long Id, UpdateCustomerRequest updateCustomerRequest);

    CustomerDto get(Long Id);

    List<CustomerDto> list();

}
