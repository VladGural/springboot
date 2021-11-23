package com.example.springboot.controller;

import com.example.springboot.dto.PaymentRequestDto;
import com.example.springboot.dto.PaymentResponseDto;
import com.example.springboot.model.Payment;
import com.example.springboot.service.PaymentService;
import com.example.springboot.service.mapper.PaymentMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    private final PaymentService paymentService;
    private final PaymentMapper paymentMapper;

    public PaymentController(PaymentService paymentService,
                             PaymentMapper paymentMapper) {
        this.paymentService = paymentService;
        this.paymentMapper = paymentMapper;
    }

    @PostMapping("/create")
    public PaymentResponseDto create(@RequestBody PaymentRequestDto requestDto) {
        Payment payment = paymentMapper.DtoToModel(requestDto);
        return paymentService.createPayment(payment);
    }
}
