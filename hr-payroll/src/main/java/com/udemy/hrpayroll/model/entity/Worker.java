package com.udemy.hrpayroll.model.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Worker implements Serializable {
    private Long id;
    private String name;
    private Double dailyIncome;
}
