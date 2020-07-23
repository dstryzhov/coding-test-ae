package com.dstryzhov.ae.service;

import com.dstryzhov.ae.dto.AccountDto;
import com.dstryzhov.ae.dto.TransactionDto;
import com.dstryzhov.ae.entities.Account;
import com.dstryzhov.ae.entities.Transaction;
import com.dstryzhov.ae.exceptions.NoAccountException;
import com.dstryzhov.ae.repositories.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {
    private static final long ACCOUNT_ID = 1;

    private final AccountRepository accountRepository;

    public AccountDto getAccount() {
        return accountRepository.findById(ACCOUNT_ID)
                .map(AccountDto::fromEntity)
                .orElseThrow(NoAccountException::new);
    }

    public void updateBalance(TransactionDto dto) {
        Account account = accountRepository.findById(ACCOUNT_ID)
                .orElseThrow(NoAccountException::new);

        if (dto.getType() == Transaction.Type.credit) {
            accountRepository.updateBalance(ACCOUNT_ID,
                    account.getBalance().subtract(dto.getAmount()));
            return;
        }
        accountRepository.updateBalance(ACCOUNT_ID, account.getBalance().add(dto.getAmount()));
    }
}
