package com.Spring_jpa.Spring_jpa.Controller;


import com.Spring_jpa.Spring_jpa.Dto.EmployeeDto;
import com.Spring_jpa.Spring_jpa.Service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {


    private final EmployeeServiceImpl employeeService;

    @Autowired
    public  EmployeeController(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployee(){
        return employeeService.getAllEmployee();
    }

    @PostMapping
    public ResponseEntity<String> postEmployee(@RequestBody EmployeeDto employeeDto){
        return employeeService.postEmployee(employeeDto);
    }


}
