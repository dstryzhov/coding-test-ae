package com.dstryzhov.ae.controllers;

import com.dstryzhov.ae.dto.AccountDto;
import com.dstryzhov.ae.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @GetMapping
    public AccountDto getAccount() {
        return accountService.getAccount();
    }
}
