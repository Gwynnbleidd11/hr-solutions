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
                .name(employeeDto.name())
                .surname(employeeDto.surname())
                .mail(employeeDto.mail())
                .birthDate(employeeDto.birthDate())
                .login(employeeDto.login())
                .password(employeeDto.password())
                .build();
    }

    public EmployeeDto mapToEmployeeDto(final Employee employee) {
        return EmployeeDto.builder()
                .id(employee.getId())
                .name(employee.getName())
                .surname(employee.getSurname())
                .mail(employee.getMail())
                .birthDate(employee.getBirthDate())
                .login(employee.getLogin())
                .password(employee.getPassword())
                .build();
    }

    public List<EmployeeDto> mapToEmployeeDtoList(final List<Employee> employeesList) {
        return employeesList.stream()
                .map(this::mapToEmployeeDto)
                .toList();
    }
}
