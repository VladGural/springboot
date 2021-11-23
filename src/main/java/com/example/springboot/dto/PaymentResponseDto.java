package com.example.springboot.dto;

import lombok.Data;

@Data
public class PaymentResponseDto {
    private Long paymentId;
    private String status;
}
