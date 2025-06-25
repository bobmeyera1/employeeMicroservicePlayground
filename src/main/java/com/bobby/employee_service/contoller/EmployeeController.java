package com.bobby.employee_service.contoller;

import com.bobby.employee_service.adaptor.EmployeeAdaptor;
import com.bobby.employee_service.dto.APIResponseDto;
import com.bobby.employee_service.dto.EmployeeDto;
import com.bobby.employee_service.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("api/employees")
public class EmployeeController
{
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/email/{email-address}")
    public ResponseEntity<APIResponseDto> getEmployeeByEmail(@PathVariable("email-address") String email) {
        Optional<APIResponseDto> result = this.employeeService.getEmployee(email);
        return result.map(apiDto -> new ResponseEntity<>(apiDto, HttpStatus.OK))
                     .orElseGet(() ->new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto dto) {
        EmployeeDto saved = this.employeeService.saveEmployee(dto);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }
}
