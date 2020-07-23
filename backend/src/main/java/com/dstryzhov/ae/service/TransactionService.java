package com.dstryzhov.ae.service;

import com.dstryzhov.ae.dto.TransactionDto;
import com.dstryzhov.ae.entities.Transaction;
import com.dstryzhov.ae.exceptions.InsufficientFundsException;
import com.dstryzhov.ae.exceptions.NoTransactionFoundException;
import com.dstryzhov.ae.repositories.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TransactionService {
    private final TransactionRepository transactionRepository;
    private final AccountService accountService;

    public List<TransactionDto> getTransactions() {
        return transactionRepository.findAll().stream()
                .map(TransactionDto::fromEntity)
                .collect(Collectors.toUnmodifiableList());
    }

    public TransactionDto create(TransactionDto dto) {
        BigDecimal balance = accountService.getAccount().getBalance();

        if (dto.getType() == Transaction.Type.credit && dto.getAmount().compareTo(balance) > 0) {
            throw new InsufficientFundsException();
        }

        accountService.updateBalance(dto);

        return TransactionDto.fromEntity(transactionRepository.save(dto.toEntity()));
    }

    public TransactionDto findById(String id) {
        return transactionRepository.findById(UUID.fromString(id))
                .map(TransactionDto::fromEntity)
                .orElseThrow(NoTransactionFoundException::new);
    }
}
