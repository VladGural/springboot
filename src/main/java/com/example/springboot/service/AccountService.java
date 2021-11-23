package com.example.springboot.service;

import com.example.springboot.model.Account;

public interface AccountService {
    Account add(Account account);

    Account get(Long id);
}
