package com.Spring_jpa.Spring_jpa.Service;

import com.Spring_jpa.Spring_jpa.Dto.EmployeeDto;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface EmployeeServiceImpl {
    ResponseEntity<List<EmployeeDto>> getAllEmployee();

    ResponseEntity<String> postEmployee(EmployeeDto employeeDto);
}
