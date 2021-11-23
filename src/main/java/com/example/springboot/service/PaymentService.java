package com.example.springboot.service;

import com.example.springboot.dto.PaymentResponseDto;
import com.example.springboot.model.Payment;

public interface PaymentService {
    PaymentResponseDto createPayment(Payment payment);
}
