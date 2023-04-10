package com.tavi903.hr.staff.mapper;

import com.tavi903.hr.staff.dto.EmployeeDTO;
import com.tavi903.hr.staff.entity.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper implements Mapper<Employee, EmployeeDTO> {

    @Override
    public EmployeeDTO toDTO(Employee employee) {
        return new EmployeeDTO(employee.getFirstName(), employee.getLastName());
    }

    @Override
    public Employee toEntity(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setFirstName(employeeDTO.firstName());
        employee.setLastName(employeeDTO.lastName());
        return employee;
    }
}
