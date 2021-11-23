package com.example.springboot.service.mapper;

import com.example.springboot.dto.ClientResponseDto;
import com.example.springboot.dto.CreateAccountRequestDto;
import com.example.springboot.dto.PaymentRequestDto;
import com.example.springboot.dto.PaymentResponseDto;
import com.example.springboot.model.Payment;
import java.math.BigDecimal;
import org.springframework.stereotype.Component;

@Component
public class PaymentMapper {
    public Payment DtoToModel(PaymentRequestDto requestDto) {
        Payment payment = new Payment();
        payment.setSource_acc_id(requestDto.getSourceAccId());
        payment.setDest_acc_id(requestDto.getDestAccId());
        payment.setAmount(new BigDecimal(requestDto.getAmount()));
        return  payment;
    }

    public PaymentResponseDto ModelToDto(Payment payment) {
        PaymentResponseDto responseDto = new PaymentResponseDto();
        responseDto.setPaymentId(payment.getId());
        responseDto.setStatus(payment.getStatus());
        return responseDto;
    }
}
