package com.residwi.microservice.transaction.controller;

import com.residwi.microservice.transaction.dto.TransactionDto;
import com.residwi.microservice.transaction.dto.ApiResponse;
import com.residwi.microservice.transaction.request.CreateTransactionRequest;
import com.residwi.microservice.transaction.service.TransactionService;
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
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping
    @ApiOperation(value = "Get all transactions")
    public ResponseEntity<ApiResponse<List<TransactionDto>>> getAll() {
        List<TransactionDto> transactions = transactionService.list();

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ApiResponse<>(
                        HttpStatus.OK.value(),
                        "OK",
                        transactions
                ));
    }

    @PostMapping
    @ApiOperation(value = "Create new transaction")
    public ResponseEntity<ApiResponse<TransactionDto>> createTransaction(@Valid @RequestBody CreateTransactionRequest createTransactionRequest) {
        TransactionDto transaction = transactionService.create(createTransactionRequest);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ApiResponse<>(
                        HttpStatus.CREATED.value(),
                        "CREATED",
                        transaction
                ));
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get transaction by id")
    public ResponseEntity<ApiResponse<TransactionDto>> getTransactionById(@PathVariable Long id) {
        TransactionDto transaction = transactionService.get(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ApiResponse<>(
                        HttpStatus.OK.value(),
                        "OK",
                        transaction
                ));
    }
}
