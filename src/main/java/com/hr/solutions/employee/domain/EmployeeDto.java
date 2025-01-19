package com.hr.solutions.employee.domain;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record EmployeeDto(
        Long id,
        String firstName,
        String lastName,
        LocalDate hireDate,
        LocalDate birthDate,
        String department,
        String role,
        String email,
        String userName,
        String password
) {
}
