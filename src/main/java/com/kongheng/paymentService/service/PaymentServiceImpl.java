package com.kongheng.paymentService.service;

import com.kongheng.paymentService.entity.TransactionDetail;
import com.kongheng.paymentService.model.PaymentMode;
import com.kongheng.paymentService.model.PaymentRequest;
import com.kongheng.paymentService.model.PaymentResponse;
import com.kongheng.paymentService.repository.TransactionDetailRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@Slf4j
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private TransactionDetailRepository transactionDetailRepository;

    @Override
    public long doPayment(PaymentRequest request) {
        TransactionDetail transactionDetail = TransactionDetail.builder()
            .paymentDate(Instant.now())
            .paymentMode(request.getPaymentMode().name())
            .paymentStatus("SUCCESS")
            .orderId(request.getOrderId())
            .referenceNumber(request.getReferenceNumber())
            .amount(request.getAmount())
            .build();

        transactionDetailRepository.save(transactionDetail);

        log.info("Transaction Completed with Id: {}", transactionDetail.getId());

        return transactionDetail.getId();
    }

    @Override
    public PaymentResponse getPaymentDetailByOrderId(String orderId) {
        TransactionDetail transactionDetail = transactionDetailRepository.findByOrderId(Long.parseLong(orderId));
        return PaymentResponse.builder()
            .paymentId(transactionDetail.getId())
            .paymentMode(PaymentMode.valueOf(transactionDetail.getPaymentMode()))
            .orderId(transactionDetail.getOrderId())
            .status(transactionDetail.getPaymentStatus())
            .amount(transactionDetail.getAmount())
            .build();
    }
}
