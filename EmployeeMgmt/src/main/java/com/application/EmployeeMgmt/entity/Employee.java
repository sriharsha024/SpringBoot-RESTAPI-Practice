package com.application.EmployeeMgmt.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long empId;

    @NotBlank(message = "Employee name cannot be blank")
    String empName;

    @NotBlank(message = "Employee city cannot be blank")
    String empCity;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "salary_account_id")
    SalaryAccount salaryAccount;

    @OneToMany(mappedBy = "employee" ,cascade = CascadeType.ALL)
    List<EmployeeAddress> employeeAddressList;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "employee_projects",
            joinColumns = @JoinColumn(name = "emp_id"),
            inverseJoinColumns = @JoinColumn(name = "project_id")
    )
    private List<Projects> projects;


}
