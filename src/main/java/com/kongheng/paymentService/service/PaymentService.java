package com.kongheng.paymentService.service;

import com.kongheng.paymentService.model.PaymentRequest;

public interface PaymentService {

    long doPayment(PaymentRequest request);

}
