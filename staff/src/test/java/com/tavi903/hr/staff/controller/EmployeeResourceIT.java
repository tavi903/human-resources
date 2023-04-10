package com.tavi903.hr.staff.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tavi903.hr.staff.dto.EmployeeDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

@AutoConfigureMockMvc
@SpringBootTest
@ActiveProfiles("test")
public class EmployeeResourceIT {
    @Autowired
    private MockMvc mockMvc;
    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void getAll() throws Exception {
        String jsonResponse =
                mockMvc.perform(
                    MockMvcRequestBuilders.get("http://localhost:8080/api/v1/employee")
                )
                .andReturn().getResponse().getContentAsString();
        var mapper = new TypeReference<List<EmployeeDTO>>() {};
        List<EmployeeDTO> employees = objectMapper.readValue(jsonResponse, mapper);
        Assertions.assertEquals(employees.size(), 3);
    }

    @Test
    public void add_Employee() throws Exception {
        var employeeDto = new EmployeeDTO("Octavian", "Dumitru");
        String jsonResponse =
                mockMvc.perform(
                                MockMvcRequestBuilders.post("http://localhost:8080/api/v1/employee")
                                        .contentType(MediaType.APPLICATION_JSON)
                                        .content(objectMapper.writeValueAsString(employeeDto))
                        )
                        .andReturn().getResponse().getContentAsString();
        var mapper = new TypeReference<EmployeeDTO>() {};
        EmployeeDTO employeeCreated= objectMapper.readValue(jsonResponse, mapper);
        Assertions.assertEquals(employeeCreated, employeeDto);
    }

}
