package com.hr.solutions.employee.service;

import com.hr.solutions.employee.controller.EmployeeNotFoundException;
import com.hr.solutions.employee.domain.Employee;
import com.hr.solutions.employee.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public Employee saveEmployee(final Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee getEmployee(final Long employeeId) throws EmployeeNotFoundException {
        return employeeRepository.findById(employeeId).orElseThrow(EmployeeNotFoundException::new);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public void deleteEmployee(final Long employeeId) {
        employeeRepository.deleteById(employeeId);
    }
}
