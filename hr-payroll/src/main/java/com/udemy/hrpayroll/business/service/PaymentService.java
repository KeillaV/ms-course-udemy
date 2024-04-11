package com.udemy.hrpayroll.business.service;

import com.udemy.hrpayroll.config.WorkerFeignClient;
import com.udemy.hrpayroll.model.entity.Payment;
import com.udemy.hrpayroll.model.entity.Worker;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private WorkerFeignClient workerFeignClient;

    public PaymentService(WorkerFeignClient workerFeignClient) {
        this.workerFeignClient = workerFeignClient;
    }

    public Payment getPayment(Long workerId, Integer days) {
        Worker worker = workerFeignClient.findById(workerId).getBody();

        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }
}
