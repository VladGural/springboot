package com.example.springboot.service;

import com.example.springboot.dto.PaymentResponseDto;
import com.example.springboot.model.Account;
import com.example.springboot.model.Payment;
import com.example.springboot.repository.PaymentRepository;
import com.example.springboot.service.mapper.PaymentMapper;
import java.math.BigDecimal;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
    private final String OK = "ok";
    private final String ERROR = "error";
    private final AccountService accountService;
    private final PaymentRepository paymentRepository;
    private final PaymentMapper paymentMapper;

    public PaymentServiceImpl(AccountService accountService,
                              PaymentRepository paymentRepository,
                              PaymentMapper paymentMapper) {
        this.accountService = accountService;
        this.paymentRepository = paymentRepository;
        this.paymentMapper = paymentMapper;
    }

    @Override
    public PaymentResponseDto createPayment(Payment payment) {
        Account sourceAcc = accountService.get(payment.getSource_acc_id());
        Account destAcc = accountService.get(payment.getDest_acc_id());
        if (sourceAcc.getBalance().compareTo(payment.getAmount()) < 0) {
            payment.setStatus(ERROR);
            paymentRepository.save(payment);
            return paymentMapper.ModelToDto(payment);
        }
        sourceAcc.setBalance(sourceAcc.getBalance().subtract(payment.getAmount()));
        destAcc.setBalance(destAcc.getBalance().add(payment.getAmount()));
        payment.setStatus(OK);
        accountService.add(sourceAcc);
        accountService.add(destAcc);
        paymentRepository.save(payment);
        return paymentMapper.ModelToDto(payment);
    }
}
