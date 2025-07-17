package org.example.greenenergydatademo;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.Collections;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Testing REST API
 */
@WebMvcTest(EnergyController.class)
class EnergyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EnergyReadingRepository repo;

    @Test
    void getAllReturnsList() throws Exception {
        // Arrange — make a fake reading:
        EnergyReading reading = new EnergyReading();
        reading.setId(1L);
        reading.setDateTime(LocalDateTime.now());
        reading.setSource(FuelType.SOLAR);
        reading.setMWh(123.4);

        when(repo.findAll()).thenReturn(Collections.singletonList(reading));

        // Act + Assert — call GET /energy and check output
        mockMvc.perform(get("/energy"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].source").value("SOLAR"))
                .andExpect(jsonPath("$[0].mWh").value(123.4));
    }

    @Test
    void addReturns200() throws Exception {
        // Arrange — input JSON string
        String json = """
            {
              "dateTime": "2024-01-01T00:00:00",
              "source": "SOLAR",
              "mWh": 50.0
            }
        """;

        EnergyReading saved = new EnergyReading();
        saved.setDateTime(LocalDateTime.parse("2024-01-01T00:00:00"));
        saved.setSource(FuelType.SOLAR);
        saved.setMWh(50.0);

        when(repo.save(Mockito.any())).thenReturn(saved);

        // Act + Assert — call POST /energy
        mockMvc.perform(post("/energy")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.source").value("SOLAR"))
                .andExpect(jsonPath("$.mWh").value(50.0));
    }
}