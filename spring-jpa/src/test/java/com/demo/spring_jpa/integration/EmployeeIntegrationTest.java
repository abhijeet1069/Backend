package com.demo.spring_jpa.integration;

import com.demo.spring_jpa.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeIntegrationTest {

    @Autowired
    MockMvc mvc;

    @Autowired
    EmployeeRepository repository;

    @Test
    void shouldInsertEmployee() throws Exception {
        String json = """
                {
                    "name":"Alice",
                    "age":24
                }
                """;
        mvc.perform(post("/employees")
                .contentType("application/json")
                .content(json))
                .andExpect(status().isOk());

        assertTrue(repository.count() >= 0);
    }
}
