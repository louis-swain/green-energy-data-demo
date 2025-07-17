package org.example.greenenergydatademo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(EnergyController.class)
class EnergyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EnergyReadingRepository repo;

    @Test
    void addReturns200() throws Exception {
        String body = """
          {
            "dateTime": "2009-01-01T00:00:00",
            "source": "SOLAR",
            "mWh": 42.5
          }
        """;

        EnergyReading saved = new EnergyReading();
        saved.setId(1L); // Simulate DB assigned ID
        saved.setDateTime(LocalDateTime.parse("2009-01-01T00:00:00"));
        saved.setSource(FuelType.SOLAR);
        saved.setMWh(42.5);

        when(repo.save(any(EnergyReading.class))).thenReturn(saved);

        mockMvc.perform(post("/energy")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.source").value("SOLAR"))
                .andExpect(jsonPath("$.mWh").value(42.5));
    }

    @Test
    void getAllReturnsList() throws Exception {
        EnergyReading reading = new EnergyReading();
        reading.setId(1L);
        reading.setDateTime(LocalDateTime.parse("2009-01-01T00:00:00"));
        reading.setSource(FuelType.SOLAR);
        reading.setMWh(42.5);

        when(repo.findAll()).thenReturn(List.of(reading));

        mockMvc.perform(get("/energy"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1L))
                .andExpect(jsonPath("$[0].source").value("SOLAR"))
                .andExpect(jsonPath("$[0].mWh").value(42.5));
    }
}