package com.example.springboot.service.mapper;

import com.example.springboot.dto.AccountResponseDto;
import com.example.springboot.dto.CreateAccountRequestDto;
import com.example.springboot.model.Account;
import java.math.BigDecimal;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {
    public Account createDtoToModel(CreateAccountRequestDto requestDto) {
        Account account = new Account();
        account.setAccountNumber(requestDto.getAccountNumber());
        account.setAccountType(requestDto.getAccountType());
        account.setBalance(new BigDecimal(requestDto.getBalance()));
        return account;
    }

    public AccountResponseDto ModelToDto(Account account) {
        AccountResponseDto responseDto = new AccountResponseDto();
        responseDto.setId(account.getId());
        responseDto.setAccountNumber(account.getAccountNumber());
        responseDto.setAccountType(account.getAccountType());
        responseDto.setBalance(account.getBalance().toString());
        return responseDto;
    }
}
