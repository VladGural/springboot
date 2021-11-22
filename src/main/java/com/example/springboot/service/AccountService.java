package com.example.springboot.service;

import com.example.springboot.dto.OwnerDto;
import com.example.springboot.model.Account;
import com.example.springboot.model.Client;

public interface AccountService {
    Account add(Account account);

    Account get(Long id);

    OwnerDto getOwner(Long id);
}
