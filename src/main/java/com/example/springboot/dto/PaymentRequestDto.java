package com.example.springboot.dto;

import lombok.Data;

@Data
public class PaymentRequestDto {
    private Long sourceAccId;
    private Long destAccId;
    private String amount;
}
