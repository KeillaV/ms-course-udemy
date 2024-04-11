package com.udemy.hrpayroll.view.controller;

import com.udemy.hrpayroll.business.service.PaymentService;
import com.udemy.hrpayroll.model.entity.Payment;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/payments")
public class PaymentController {

    private PaymentService service;

    @GetMapping("/{workerId}/days/{days}")
    public ResponseEntity<Payment> getPayment(@PathVariable Long workerId, @PathVariable Integer days) {
        return ResponseEntity.ok(service.getPayment(workerId, days));
    }
}
