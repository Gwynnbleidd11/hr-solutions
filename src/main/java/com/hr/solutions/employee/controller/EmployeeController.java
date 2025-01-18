package com.hr.solutions.employee.controller;

import com.hr.solutions.employee.domain.Employee;
import com.hr.solutions.employee.domain.EmployeeDto;
import com.hr.solutions.employee.mapper.EmployeeMapper;
import com.hr.solutions.employee.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;
    private final EmployeeMapper employeeMapper;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createEmployee(@RequestBody EmployeeDto employeeDto) {
        Employee employee = employeeMapper.mapToEmployee(employeeDto);
        employeeService.saveEmployee(employee);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "{employeeId}")
    public ResponseEntity<EmployeeDto> getEmployee(@PathVariable Long employeeId) throws EmployeeNotFoundException {
        return ResponseEntity.ok(employeeMapper.mapToEmployeeDto(employeeService.getEmployee(employeeId)));
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getUsers() {
        List<Employee> employeesList = employeeService.getAllEmployees();
        return ResponseEntity.ok(employeeMapper.mapToEmployeeDtoList(employeesList));
    }

    @PutMapping
    public ResponseEntity<EmployeeDto> updateEmployee(@RequestBody EmployeeDto employeeDto) {
        Employee employee = employeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeService.saveEmployee(employee);
        return ResponseEntity.ok(employeeMapper.mapToEmployeeDto(savedEmployee));
    }

    @DeleteMapping(value = "{employeeId}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long employeeId) {
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.noContent().build();
    }
}
