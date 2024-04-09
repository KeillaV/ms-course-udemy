package com.udemy.hrworker.model.repository;

import com.udemy.hrworker.model.entity.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepository extends JpaRepository<Worker,Long> {
    public boolean existsByName(String name);
}
