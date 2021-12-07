package com.reeves122.microairlines.api.test;

import com.jayway.jsonpath.JsonPath;
import com.reeves122.microairlines.api.controller.CitiesController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

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
        MvcResult result = mockMvc.perform(post("/api/v1/players"))
                .andExpect(status().isCreated())
                .andReturn();
        Integer id = JsonPath.read(result.getResponse().getContentAsString(), "$.id");

        mockMvc.perform(post("/api/v1/cities?player_id=" + id))
                .andExpect(status().isCreated());
    }

    @Test
    @DirtiesContext
    public void shouldReturnById() throws Exception {
        MvcResult playerResult = mockMvc.perform(post("/api/v1/players"))
                .andExpect(status().isCreated())
                .andReturn();
        Integer playerId = JsonPath.read(playerResult.getResponse().getContentAsString(), "$.id");

        MvcResult cityResult = mockMvc.perform(post("/api/v1/cities?player_id=" + playerId))
                .andExpect(status().isCreated())
                .andReturn();
        Integer cityId = JsonPath.read(cityResult.getResponse().getContentAsString(), "$.id");

        mockMvc.perform(get("/api/v1/cities/" + cityId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("New York")));
    }
}