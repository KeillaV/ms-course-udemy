package com.udemy.hrworker.model.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.io.Serializable;

@Data
@Entity
public class Worker implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @NotBlank(message = "Worker name should not be blank!")
    private String name;

    @Positive(message = "Worker income should be a positive value!")
    private Double dailyIncome;
}
