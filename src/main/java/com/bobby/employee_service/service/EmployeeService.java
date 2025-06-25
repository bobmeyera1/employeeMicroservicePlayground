package com.bobby.employee_service.service;

import com.bobby.employee_service.dto.APIResponseDto;
import com.bobby.employee_service.dto.EmployeeDto;

import java.util.Optional;

public interface EmployeeService {

    public EmployeeDto saveEmployee(EmployeeDto employee);

    public Optional<APIResponseDto> getEmployee(String email);

}
