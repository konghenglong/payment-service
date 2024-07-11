package com.kongheng.paymentService.controller;

import com.kongheng.paymentService.model.PaymentRequest;
import com.kongheng.paymentService.model.PaymentResponse;
import com.kongheng.paymentService.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping
    public ResponseEntity<Long> doPayment(@RequestBody PaymentRequest request) {
        return ResponseEntity.ok().body(paymentService.doPayment(request));
    }

    @GetMapping("/order/{orderId}")
    public ResponseEntity<PaymentResponse> getPaymentDetailByOrderId(@PathVariable String orderId) {
        return ResponseEntity.ok().body(paymentService.getPaymentDetailByOrderId(orderId));
    }

}
