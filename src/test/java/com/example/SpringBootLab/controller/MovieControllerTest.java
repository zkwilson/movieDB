package com.example.SpringBootLab.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
@DisplayName("Movie Controller Test")
public class MovieControllerTest {
    private MockMvc mockMvc;
    private List<Movie> movieList = new ArrayList<>();

    @InjectMocks
    private MovieController subject;

    @BeforeEach
    void setup() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(subject).build();
        Movie darkKnight = new Movie("Dark Knight", "Action", "PG-13");
        Movie up = new Movie("Up", "Family", "PG");
        Movie sinister = new Movie("Sinister", "Horror", "R");
        Movie dieHard = new Movie("Die Hard", "Action", "R");
        movieList.add(darkKnight);
        movieList.add(up);
        movieList.add(sinister);
        movieList.add(dieHard);
        mockMvc.perform(post("/api/v1/movies", darkKnight));
    }


    @Test
    @DisplayName("Testing get All Movies")
    void testGet() throws Exception {

        // When
        MockHttpServletResponse response =
                mockMvc
                        .perform(get("/api/v1/movies"))
                        .andReturn()
                        .getResponse();


        // Then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("h");
    }

   /* @Test
    @DisplayName("Testing get movie by ID")
    void testGetbyID() throws Exception {

        // When
        MockHttpServletResponse response =
                mockMvc
                        .perform(get("/api/v1/movies/{id}"))
                        .andReturn()
                        .getResponse();

        // Then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }

    @Test
    @DisplayName("Testing get movie by category")
    void testGetByCategory() throws Exception {

        // When
        MockHttpServletResponse response =
                mockMvc
                        .perform(get("/search/findByCategory/{category}"))
                        .andReturn()
                        .getResponse();

        // Then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }*/
}
