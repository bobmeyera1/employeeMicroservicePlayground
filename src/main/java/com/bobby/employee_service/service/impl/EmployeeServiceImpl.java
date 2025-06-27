package com.bobby.employee_service.service.impl;

import com.bobby.employee_service.adaptor.EmployeeAdaptor;
import com.bobby.employee_service.dto.APIResponseDto;
import com.bobby.employee_service.dto.DepartmentDto;
import com.bobby.employee_service.dto.EmployeeDto;
import com.bobby.employee_service.entity.Employee;
import com.bobby.employee_service.repository.EmployeeRepository;
import com.bobby.employee_service.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final APIClient apiClient;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, APIClient apiClient) {
        this.employeeRepository = employeeRepository;
        this.apiClient = apiClient;
    }

    @Override
    public EmployeeDto saveEmployee(EmployeeDto dto) {
        Employee resultEntity = this.employeeRepository.save(EmployeeAdaptor.toEntity(dto));
        return EmployeeAdaptor.toDto(resultEntity);
    }

    @Override
    public Optional<APIResponseDto> getEmployee(String email) {
        Optional<Employee> result = this.employeeRepository.findByEmail(email);
        if (result.isPresent()) {
            Employee employee = result.get();
            DepartmentDto departmentDto = apiClient.getDepartmentByCode(employee.getDepartmentCode());
            APIResponseDto response = new APIResponseDto(EmployeeAdaptor.toDto(employee), departmentDto);
            return Optional.of(response);
        } else {
            return Optional.empty();
        }
    }
}
