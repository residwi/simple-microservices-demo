package com.residwi.microservice.customer.service.mapper;

import com.residwi.microservice.customer.dto.CustomerDto;
import com.residwi.microservice.customer.entity.Customer;
import com.residwi.microservice.customer.request.CreateCustomerRequest;
import com.residwi.microservice.customer.request.UpdateCustomerRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerDto toDTO(Customer customer);

    List<CustomerDto> toDTOs(List<Customer> customer);

    Customer toEntity(CreateCustomerRequest createCustomerRequest);

    Customer toEntity(UpdateCustomerRequest updateCustomerRequest, @MappingTarget Customer customer);
}
