package com.residwi.microservice.transaction.service;

import com.residwi.microservice.transaction.dto.TransactionDto;
import com.residwi.microservice.transaction.request.CreateTransactionRequest;

import java.util.List;

public interface TransactionService {

    TransactionDto create(CreateTransactionRequest createTransactionRequest);

    TransactionDto get(Long id);

    List<TransactionDto> list();

}
