package com.bobby.employee_service.service.impl;

import com.bobby.employee_service.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "DEPARTMENT-SERVICE")
public interface APIClient {
    @GetMapping("api/departments/code/{department-code}")
    DepartmentDto getDepartmentByCode(@PathVariable("department-code") String departmentCode);
}
