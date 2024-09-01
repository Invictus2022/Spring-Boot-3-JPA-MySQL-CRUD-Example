package com.Spring_jpa.Spring_jpa.Repository;

import com.Spring_jpa.Spring_jpa.Model.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeModel , Integer> {
}
