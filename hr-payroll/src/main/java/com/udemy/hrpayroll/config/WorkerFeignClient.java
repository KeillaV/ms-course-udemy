package com.udemy.hrpayroll.config;

import com.udemy.hrpayroll.model.entity.Worker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "${spring.application.name}", url = "${hr-worker.host}", path = "${hr-worker.path}")
public interface WorkerFeignClient {

    @GetMapping("/{id}")
    public ResponseEntity<Worker> findById(@PathVariable Long id);
}
