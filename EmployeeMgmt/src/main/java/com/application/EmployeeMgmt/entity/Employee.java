package com.application.EmployeeMgmt.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;
import java.util.ArrayList;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long empId;

    @NotBlank(message = "Employee name cannot be blank")
    private String empName;

    @NotBlank(message = "Employee city cannot be blank")
    private String empCity;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "salary_account_id")
    private SalaryAccount salaryAccount;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, mappedBy = "employee")
    private List<EmployeeAddress> employeeAddressList;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "employee_projects",
            joinColumns = @JoinColumn(name = "emp_id"),
            inverseJoinColumns = @JoinColumn(name = "project_id")
    )
    private Set<Projects> projects;

    public Employee(String empName, String empCity) {
        this.empName = empName;
        this.empCity = empCity;
    }

    public void removeProject(Projects project) {
        this.projects.remove(project);
        project.getEmployees().remove(project);
    }

    public void addProject(Projects project) {
        this.projects.add(project);
        project.getEmployees().add(this);
    }

    public Set<Projects> getProjects() {
        return projects;
    }

    public void setProjects(Set<Projects> projects) {
        this.projects = projects;
    }

    public void addAddress(EmployeeAddress address) {
        if (this.employeeAddressList == null) {
            this.employeeAddressList = new ArrayList<>();
        }
        this.employeeAddressList.add(address);
        address.setEmployee(this);
    }

    public void removeAddress(EmployeeAddress address) {
        if (this.employeeAddressList != null) {
            this.employeeAddressList.remove(address);
            address.setEmployee(null);
        }
    }
}
