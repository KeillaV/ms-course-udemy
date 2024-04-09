package com.udemy.hrworker.model.service;

import com.udemy.hrworker.model.entity.Worker;
import com.udemy.hrworker.model.repository.WorkerRepository;
import com.udemy.hrworker.view.exception.ResourceAlreadyExistsException;
import com.udemy.hrworker.view.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class WorkerServiceImpl implements WorkerService {
    private WorkerRepository repository;

    @Override
    public List<Worker> getAll() {
        return repository.findAll();
    }

    @Override
    @SneakyThrows
    public Worker getById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("worker", "id", id.toString()));
    }

    @Override
    @SneakyThrows
    public Worker save(Worker worker) {
        if (repository.existsByName(worker.getName())) {
            throw new ResourceAlreadyExistsException("worker", "name", worker.getName());
        }
        return repository.save(worker);
    }

    @Override
    @SneakyThrows
    public Worker update(Long id, Worker worker) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("worker", "id", id.toString());
        }

        worker.setId(id);
        return repository.save(worker);
    }

    @Override
    @SneakyThrows
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("worker", "id", id.toString());
        }
        repository.deleteById(id);
    }
}
