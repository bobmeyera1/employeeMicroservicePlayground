package com.bobby.employee_service.adaptor;

import com.bobby.employee_service.dto.EmployeeDto;
import com.bobby.employee_service.entity.Employee;

public class EmployeeAdaptor {

    public static EmployeeDto toDto(Employee entity) {
        return new EmployeeDto(
                entity.getId(),
                entity.getFirstName(),
                entity.getLastName(),
                entity.getEmail(),
                entity.getDepartmentCode());
    }

    public static Employee toEntity(EmployeeDto dto) {
        return new Employee(
                dto.getId(),
                dto.getFirstName(),
                dto.getLastName(),
                dto.getEmail(),
                dto.getDepartmentCode());
    }
}
