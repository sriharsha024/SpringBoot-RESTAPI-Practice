package com.application.EmployeeMgmt.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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
    @NotNull
    private double salary;
    @NotNull
    private double accountBalance;
    @NotNull
    private String accountType;

    @OneToOne(mappedBy = "salaryAccount")
    private Employee employee;

}
