package com.example.springboot.controller;

import com.example.springboot.dto.AccountResponseDto;
import com.example.springboot.dto.CreateAccountRequestDto;
import com.example.springboot.model.Account;
import com.example.springboot.model.Client;
import com.example.springboot.service.AccountService;
import com.example.springboot.service.ClientService;
import com.example.springboot.service.mapper.AccountMapper;
import com.example.springboot.service.mapper.ClientMapper;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {
    private final AccountMapper accountMapper;
    private final AccountService accountService;
    private final ClientService clientService;
    private final ClientMapper clientMapper;

    public AccountController(AccountMapper accountMapper,
                             AccountService accountService,
                             ClientService clientService,
                             ClientMapper clientMapper) {
        this.accountMapper = accountMapper;
        this.accountService = accountService;
        this.clientService = clientService;
        this.clientMapper = clientMapper;
    }

    @PostMapping("/add/{id}")
    public AccountResponseDto add(@PathVariable Long id,
                                  @RequestBody CreateAccountRequestDto createAccountRequestDto) {
        Client client = clientService.get(id);
        Account account = accountMapper.createDtoToModel(createAccountRequestDto);
        account.setClient(client);
        accountService.add(account);
        return accountMapper.ModelToDto(account);
    }
}
