package com.reeves122.microairlines.api.test;

import com.reeves122.microairlines.api.controller.CitiesController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CitiesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CitiesController controller;

    @Test
    public void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }

    @Test
    public void shouldBeEmpty() throws Exception {
        mockMvc.perform(get("/api/v1/cities"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(0)));
    }

    @Test
    @DirtiesContext
    public void shouldCreateNew() throws Exception {
        mockMvc.perform(post("/api/v1/cities"))
                .andExpect(status().isOk());
    }

    @Test
    @DirtiesContext
    public void shouldReturnById() throws Exception {
        mockMvc.perform(post("/api/v1/cities"));

        mockMvc.perform(get("/api/v1/cities/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("New York")));
    }
}