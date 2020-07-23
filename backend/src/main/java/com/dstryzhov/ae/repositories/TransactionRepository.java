package com.dstryzhov.ae.repositories;

import com.dstryzhov.ae.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TransactionRepository extends JpaRepository<Transaction, UUID> {
}
