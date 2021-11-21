package com.example.springboot.service;

import com.example.springboot.model.Account;
import com.example.springboot.repository.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account add(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account get(Long id) {
        return accountRepository.findById(id).get();
    }
}
