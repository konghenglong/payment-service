package com.kongheng.paymentService.service;

import com.kongheng.paymentService.model.PaymentRequest;
import com.kongheng.paymentService.model.PaymentResponse;

public interface PaymentService {

    long doPayment(PaymentRequest request);

    PaymentResponse getPaymentDetailByOrderId(String orderId);
}
