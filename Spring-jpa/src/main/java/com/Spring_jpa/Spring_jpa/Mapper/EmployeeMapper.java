package com.Spring_jpa.Spring_jpa.Mapper;

import com.Spring_jpa.Spring_jpa.Dto.EmployeeDto;
import com.Spring_jpa.Spring_jpa.Model.EmployeeModel;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {
    public EmployeeDto mapToEmployeeDto(EmployeeModel employee) {
        return new EmployeeDto(employee.getId(), employee.getEmployeeName(),
                employee.getEmployeeDepartment());
    }

    public  EmployeeModel mapToEmployee(EmployeeDto employeeDto) {
        return new EmployeeModel(employeeDto.getId(), employeeDto.getEmployeeName(),
                employeeDto.getEmployeeDepartment());
    }
}
