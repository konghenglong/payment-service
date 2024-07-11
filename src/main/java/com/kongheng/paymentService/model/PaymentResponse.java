package com.kongheng.paymentService.model;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder
public class PaymentResponse {

    private long paymentId;

    private String status;

    private PaymentMode paymentMode;

    private long amount;

    private Instant paymentDate;

    private long orderId;

}
