package com.application.EmployeeMgmt.service;

import com.application.EmployeeMgmt.entity.Employee;
import com.application.EmployeeMgmt.entity.EmployeeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.application.EmployeeMgmt.repository.EmployeeRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepo employeeRepo;

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employees = employeeRepo.findAll();
        if (employees == null) {
            return null;
        }
        return employees;
    }

    @Override
    public Optional<Employee> getEmployeeById(long employeeId) {
        return employeeRepo.findById(employeeId);
    }

    @Override
    public Employee addEmployee(Employee employee) {
        ArrayList<EmployeeAddress> addressArrayList = new ArrayList<>();

        for (EmployeeAddress address : employee.getEmployeeAddressList()) {
            EmployeeAddress newAddress = new EmployeeAddress(
                    address.getAddressLine1(),
                    address.getAddressLine2(),
                    address.getCity(),
                    address.getState(),
                    address.getCountry(),
                    address.getPostalCode(),
                    employee
            );

            addressArrayList.add(newAddress);
        }

        employee.setEmployeeAddressList(addressArrayList);

        return employeeRepo.save(employee);
    }

    @Override
    public Employee updateEmployeeDetails(long employeeId, Employee employee) {
        Optional<Employee> employeefromDB = employeeRepo.findById(employeeId);
        if (employeefromDB.isEmpty()) {
            return null;
        }
        Employee existingEmployee = employeefromDB.get();
        existingEmployee.setEmpName(employee.getEmpName());
        existingEmployee.setEmpCity(employee.getEmpCity());
        employeeRepo.save(existingEmployee);
        return existingEmployee;
    }

    @Override
    public boolean deleteEmployeeDetails(long employeeId) {
        Optional<Employee> employee = employeeRepo.findById(employeeId);
        if (employee.isPresent()) {
            employeeRepo.delete(employee.get());
            return true;
        }
        return false;
    }
}
