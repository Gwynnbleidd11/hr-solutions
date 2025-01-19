package com.hr.solutions.employee.mapper;

import com.hr.solutions.employee.domain.Employee;
import com.hr.solutions.employee.domain.EmployeeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeMapper {

    public Employee mapToEmployee(final EmployeeDto employeeDto) {
        return Employee.builder()
                .id(employeeDto.id())
                .firstName(employeeDto.firstName())
                .lastName(employeeDto.lastName())
                .hireDate(employeeDto.hireDate())
                .birthDate(employeeDto.birthDate())
                .department(employeeDto.department())
                .role(Employee.Role.valueOf(employeeDto.role()))
                .email(employeeDto.email())
                .userName(employeeDto.userName())
                .password(employeeDto.password())
                .build();
    }

    public EmployeeDto mapToEmployeeDto(final Employee employee) {
        return EmployeeDto.builder()
                .id(employee.getId())
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .hireDate(employee.getHireDate())
                .birthDate(employee.getBirthDate())
                .department(employee.getDepartment())
                .role(employee.getRole().toString())
                .email(employee.getEmail())
                .userName(employee.getUserName())
                .password(employee.getPassword())
                .build();
    }

    public List<EmployeeDto> mapToEmployeeDtoList(final List<Employee> employeesList) {
        return employeesList.stream()
                .map(this::mapToEmployeeDto)
                .toList();
    }
}
