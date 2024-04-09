package com.udemy.hrworker.controller;

import com.udemy.hrworker.model.entity.Worker;
import com.udemy.hrworker.model.service.WorkerServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/workers")
@AllArgsConstructor
public class WorkerController {

    private WorkerServiceImpl service;

    @GetMapping
    public ResponseEntity<List<Worker>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Worker> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    public ResponseEntity<Worker> save(@Valid @RequestBody Worker worker) {
        return new ResponseEntity(service.save(worker), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Worker> update(@PathVariable Long id, @Valid @RequestBody Worker worker) {
        return ResponseEntity.ok(service.update(id, worker));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
