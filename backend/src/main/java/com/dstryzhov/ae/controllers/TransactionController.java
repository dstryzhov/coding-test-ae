package com.dstryzhov.ae.controllers;

import com.dstryzhov.ae.dto.TransactionDto;
import com.dstryzhov.ae.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    @GetMapping
    public List<TransactionDto> getAll() {
        return transactionService.getTransactions();
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @PostMapping
    public TransactionDto create(@RequestBody TransactionDto dto) {
        return transactionService.create(dto);
    }

    @GetMapping
    @RequestMapping("/{id}")
    public TransactionDto findById(@PathVariable("id") String id) {
        return transactionService.findById(id);
    }
}
