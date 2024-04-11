package com.udemy.hrworker.business.service;

import com.udemy.hrworker.model.entity.Worker;

import java.util.List;

public interface WorkerService {
    public List<Worker> getAll();
    public Worker getById(Long id);
    public Worker save(Worker worker);
    public Worker update(Long id, Worker worker);
    public void delete(Long id);
}
