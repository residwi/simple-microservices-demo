package com.residwi.microservice.customer.controller;

import com.residwi.microservice.customer.dto.CustomerDto;
import com.residwi.microservice.customer.dto.ApiResponse;
import com.residwi.microservice.customer.request.CreateCustomerRequest;
import com.residwi.microservice.customer.request.UpdateCustomerRequest;
import com.residwi.microservice.customer.service.CustomerService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/", produces = "application/json")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    @ApiOperation(value = "Get all customers")
    public ResponseEntity<ApiResponse<List<CustomerDto>>> getAll() {
        List<CustomerDto> customers = customerService.list();

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ApiResponse<>(
                        HttpStatus.OK.value(),
                        "OK",
                        customers
                ));
    }

    @PostMapping
    @ApiOperation(value = "Create new customer")
    public ResponseEntity<ApiResponse<CustomerDto>> createCustomer(@Valid @RequestBody CreateCustomerRequest createCustomerRequest) {
        CustomerDto customer = customerService.create(createCustomerRequest);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ApiResponse<>(
                        HttpStatus.CREATED.value(),
                        "CREATED",
                        customer
                ));
    }

    @GetMapping("/{Id}")
    @ApiOperation(value = "Get customer by Id")
    public ResponseEntity<ApiResponse<CustomerDto>> getCustomerById(@PathVariable Long Id) {
        CustomerDto customer = customerService.get(Id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ApiResponse<>(
                        HttpStatus.OK.value(),
                        "OK",
                        customer
                ));
    }

    @PutMapping("/{Id}")
    @ApiOperation(value = "Update customer by Id  ")
    public ResponseEntity<ApiResponse<CustomerDto>> updateCustomer(@PathVariable Long Id, @Valid @RequestBody UpdateCustomerRequest updateCustomerRequest) {
        CustomerDto customer = customerService.update(Id, updateCustomerRequest);

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ApiResponse<>(
                        HttpStatus.OK.value(),
                        "OK",
                        customer
                ));
    }
}
