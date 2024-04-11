package com.udemy.hrpayroll.business.service;

import com.udemy.hrpayroll.model.entity.Payment;
import com.udemy.hrpayroll.model.entity.Worker;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService {

    @Value("${hr-worker.host}")
    private String workerHost;

    private RestTemplate restTemplate;

    public PaymentService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Payment getPayment(Long workerId, Integer days) {
        Map<String, String> uriVariable = new HashMap<>();
        uriVariable.put("id", String.valueOf(workerId));

        Worker worker = restTemplate.getForObject(workerHost + "/workers/{id}", Worker.class, uriVariable);

        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }
}
