package com.udemy.hrpayroll.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.io.Serializable;

@AllArgsConstructor
@Data
public class Payment implements Serializable {

    private String name;
    private Double dailyIncome;
    private Integer days;

    public double getTotal() {
        return dailyIncome * days;
    }
}
