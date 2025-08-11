package com.example.employeeapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void getEmployees_returnsOkAndAList() throws Exception {
        MvcResult res = mockMvc.perform(get("/employees"))
                .andExpect(status().isOk())
                .andReturn();

        String json = res.getResponse().getContentAsString();
        Employees employees = objectMapper.readValue(json, Employees.class);
        assertThat(employees.getEmployees()).isNotNull();
        assertThat(employees.getEmployees().size()).isGreaterThan(0);
    }

    @Test
    void postEmployees_createsAndReturnsEmployee() throws Exception {
        Employee e = new Employee("E778","Kushal","Gudibandi","kushal@example.com","DevOps Engineer");
        String body = objectMapper.writeValueAsString(e);

        MvcResult res = mockMvc.perform(post("/employees")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body))
                .andExpect(status().isCreated())
                .andReturn();

        String json = res.getResponse().getContentAsString();
        Employee created = objectMapper.readValue(json, Employee.class);
        assertThat(created.getEmployee_id()).isEqualTo("E778");
        assertThat(created.getFirst_name()).isEqualTo("Kushal");
        assertThat(created.getLast_name()).isEqualTo("Gudibandi");
        assertThat(created.getEmail()).isEqualTo("kushal@example.com");
        assertThat(created.getTitle()).isEqualTo("DevOps Engineer");
    }
}
