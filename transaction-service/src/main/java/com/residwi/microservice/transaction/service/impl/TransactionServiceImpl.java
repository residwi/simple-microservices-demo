package com.residwi.microservice.transaction.service.impl;

import com.residwi.microservice.transaction.dto.ApiResponse;
import com.residwi.microservice.transaction.dto.ProductDto;
import com.residwi.microservice.transaction.dto.TransactionDto;
import com.residwi.microservice.transaction.entity.Transaction;
import com.residwi.microservice.transaction.handler.NotFoundException;
import com.residwi.microservice.transaction.repository.TransactionRepository;
import com.residwi.microservice.transaction.request.CreateTransactionRequest;
import com.residwi.microservice.transaction.service.TransactionService;
import com.residwi.microservice.transaction.service.mapper.TransactionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private TransactionMapper transactionMapper;

    @Override
    public TransactionDto create(CreateTransactionRequest createTransactionRequest) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://product:8300/" + createTransactionRequest.getProductId();

        ResponseEntity<ApiResponse<ProductDto>> product = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<ApiResponse<ProductDto>>() {
                }
        );

        if (product.getBody() == null) {
            throw new NotFoundException();
        }

        Transaction transaction = transactionMapper.toEntity(createTransactionRequest);
        transaction.setPrice(product.getBody().getData().getPrice());
        transaction.setTotal((double) transaction.getQuantity() * product.getBody().getData().getPrice());

        transactionRepository.save(transaction);

        return transactionMapper.toDTO(transaction);
    }

    @Override
    public TransactionDto get(Long id) {
        Transaction transaction = findTransactionByIdOrThrowNotFound(id);

        return transactionMapper.toDTO(transaction);
    }

    @Override
    public List<TransactionDto> list() {
        List<Transaction> transactions = transactionRepository.findAll();

        return transactionMapper.toDTOs(transactions);
    }

    private Transaction findTransactionByIdOrThrowNotFound(Long id) {
        return transactionRepository.findById(id).orElseThrow(NotFoundException::new);
    }

}
