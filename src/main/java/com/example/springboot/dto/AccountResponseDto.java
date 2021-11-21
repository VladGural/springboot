package com.example.springboot.dto;

import lombok.Data;

@Data
public class AccountResponseDto {
    private Long id;
    private String accountNumber;
    private String accountType;
    private String balance;
}
