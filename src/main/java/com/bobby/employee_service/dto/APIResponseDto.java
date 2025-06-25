package com.bobby.employee_service.dto;

import com.bobby.employee_service.entity.Employee;

public class APIResponseDto {
    private EmployeeDto employee;
    private DepartmentDto department;

    public APIResponseDto() {
    }

    public APIResponseDto(EmployeeDto employee, DepartmentDto department) {
        this.employee = employee;
        this.departmentDto = department;
    }

    public EmployeeDto getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeDto employee) {
        this.employee = employee;
    }

    public DepartmentDto getDepartment() {
        return department;
    }

    public void setDepartmentDto(DepartmentDto department) {
        this.departmentDto = department;
    }
}
