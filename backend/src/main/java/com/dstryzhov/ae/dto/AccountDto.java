package com.dstryzhov.ae.dto;

import com.dstryzhov.ae.entities.Account;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class AccountDto {
    private BigDecimal balance;

    public static AccountDto fromEntity(Account entity) {
        AccountDto accountDto = new AccountDto();
        accountDto.setBalance(entity.getBalance());
        return accountDto;
    }
}
