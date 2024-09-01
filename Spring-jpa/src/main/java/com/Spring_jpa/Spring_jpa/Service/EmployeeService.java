package com.Spring_jpa.Spring_jpa.Service;


import com.Spring_jpa.Spring_jpa.Dto.EmployeeDto;
import com.Spring_jpa.Spring_jpa.Mapper.EmployeeMapper;
import com.Spring_jpa.Spring_jpa.Model.EmployeeModel;
import com.Spring_jpa.Spring_jpa.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService implements EmployeeServiceImpl {



    private final   EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository,
                           EmployeeMapper employeeMapper) {
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
    }


    @Override
    public ResponseEntity<List<EmployeeDto>> getAllEmployee(){
        // Get all EmployeeModel objects
        List<EmployeeModel> employeeModel =  employeeRepository.findAll();

        List<EmployeeDto> employeeDto = employeeModel.stream()

                // Map each EmployeeModel to EmployeeDto
                .map(employeeMapper::mapToEmployeeDto)

                // Collect the mapped objects into a list
                .collect(Collectors.toList());
        return new ResponseEntity<>(employeeDto, HttpStatus.OK) ;
    }

    @Override
    public ResponseEntity<String> postEmployee(EmployeeDto employeeDto){
          EmployeeModel employee = employeeMapper.mapToEmployee(employeeDto);
          EmployeeModel employeeModel = employeeRepository.save(employee);
//          EmployeeDto employeeDto1 = employeeMapper.mapToEmployeeDto(employeeModel);
          return new ResponseEntity<>("Employee Sucessfully added",HttpStatus.OK);
    }
}
