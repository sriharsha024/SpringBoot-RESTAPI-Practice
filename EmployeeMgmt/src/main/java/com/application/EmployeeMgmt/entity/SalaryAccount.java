package com.application.EmployeeMgmt.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SalaryAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long accountId;
    private double salary;
    private double accountBalance;
    private String accountType;

    @OneToOne(mappedBy = "salaryAccount")
    private Employee employee;

    public SalaryAccount(double salary, double accountBalance, String accountType, Employee employee) {
        this.salary = salary;
        this.accountBalance = accountBalance;
        this.accountType = accountType;
        this.employee = employee;
    }
}
