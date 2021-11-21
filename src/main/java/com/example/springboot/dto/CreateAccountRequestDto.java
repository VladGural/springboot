package com.example.springboot.dto;

import lombok.Data;

@Data
public class CreateAccountRequestDto {
    private String id;
    private String accountNumber;
    private String accountType;
    private String balance;
}
