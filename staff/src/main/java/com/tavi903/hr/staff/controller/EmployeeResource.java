package com.tavi903.hr.staff.controller;

import com.tavi903.hr.staff.dto.EmployeeDTO;
import com.tavi903.hr.staff.mapper.EmployeeMapper;
import com.tavi903.hr.staff.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/employee")
@RequiredArgsConstructor
public class EmployeeResource {

    private final EmployeeService employeeService;
    private final EmployeeMapper employeeMapper;

    @PostMapping
    public EmployeeDTO addEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return employeeMapper.toDTO(
                employeeService.addEmployee(employeeMapper.toEntity(employeeDTO))
        );
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<EmployeeDTO> retrieveAllEmployees() {
        return employeeMapper.toDTOs(employeeService.findAll());
    }

}
