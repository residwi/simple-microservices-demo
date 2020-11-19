package com.residwi.microservice.transaction.service.mapper;

import com.residwi.microservice.transaction.dto.TransactionDto;
import com.residwi.microservice.transaction.entity.Transaction;
import com.residwi.microservice.transaction.request.CreateTransactionRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TransactionMapper {
    TransactionDto toDTO(Transaction transaction);

    List<TransactionDto> toDTOs(List<Transaction> transaction);

    Transaction toEntity(CreateTransactionRequest createTransactionRequest);
}
