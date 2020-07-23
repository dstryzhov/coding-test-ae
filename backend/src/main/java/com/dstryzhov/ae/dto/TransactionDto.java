package com.dstryzhov.ae.dto;

import com.dstryzhov.ae.entities.Transaction;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
public class TransactionDto {
    private UUID id;
    private Transaction.Type type;
    private BigDecimal amount;
    private Date effectiveDate;

    public static TransactionDto fromEntity(Transaction entity) {
        TransactionDto transactionDto = new TransactionDto();
        transactionDto.setId(entity.getId());
        transactionDto.setType(entity.getType());
        transactionDto.setAmount(entity.getAmount());
        transactionDto.setEffectiveDate(entity.getEffectiveDate());
        return transactionDto;
    }

    public Transaction toEntity() {
        return new Transaction(this.type, this.amount);
    }
}
