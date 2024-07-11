package com.kongheng.paymentService.model;

import lombok.Data;

@Data
public class PaymentRequest {

    private long orderId;

    private long amount;

    private String referenceNumber;

    private PaymentMode paymentMode;

}
