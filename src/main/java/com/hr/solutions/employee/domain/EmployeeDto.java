package com.hr.solutions.employee.domain;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record EmployeeDto(
        Long id,
        String name,
        String surname,
        String mail,
        LocalDate birthDate,
        String login,
        String password
) {
}
