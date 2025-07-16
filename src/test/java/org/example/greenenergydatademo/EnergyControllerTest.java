package org.example.greenenergydatademo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EnergyController.class)
public class EnergyControllerTest
{
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EnergyReadingRepository repo;

    @Test
    void getAllReturns200() throws Exception {
        when(repo.findAll()).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/energy"))
                .andExpect(status().isOk());
    }

    @Test
    void addReturns200() throws Exception {
        String body = """
          {
            "source": "Solar",
            "kWh": 42.5
          }
        """;

        EnergyReading fake = new EnergyReading(1L, "Solar", 42.5);
        when(repo.save(fake)).thenReturn(fake);

        mockMvc.perform(post("/energy")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body))
                .andExpect(status().isOk());
    }
}
