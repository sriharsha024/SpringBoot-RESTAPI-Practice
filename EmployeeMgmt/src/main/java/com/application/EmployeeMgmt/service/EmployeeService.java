package com.application.EmployeeMgmt.service;

import com.application.EmployeeMgmt.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    Optional<Employee> getEmployeeById(long employeeId);
    Employee addEmployee(Employee employee);
    Employee updateEmployeeDetails(long employeeId, Employee employee);
    boolean deleteEmployeeDetails(long employeeId);
}
