package org.example.greenenergydatademo;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Tests the Thymeleaf view controller including filters.
 */
@WebMvcTest(EnergyViewController.class)
class EnergyViewControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EnergyReadingRepository repo;

    @Test
    void energyViewReturnsHtml() throws Exception {
        // Arrange
        EnergyReading reading = new EnergyReading();
        reading.setId(1L);
        reading.setDateTime(LocalDateTime.of(2024, 1, 1, 0, 0));
        reading.setSource(FuelType.SOLAR);
        reading.setMWh(123.4);

        Page<EnergyReading> fakePage = new PageImpl<>(
                List.of(reading),
                PageRequest.of(0, 20),
                1
        );

        Mockito.when(repo.findAll(any(Pageable.class)))
                .thenReturn(fakePage);

        // Act & Assert
        mockMvc.perform(get("/energy-view"))
                .andExpect(status().isOk())
                .andExpect(content().string(org.hamcrest.Matchers.containsString("123.4")))
                .andExpect(content().string(org.hamcrest.Matchers.containsString("SOLAR")))
                .andExpect(view().name("energy"));
    }

    @Test
    void energyViewWithFilterReturnsFilteredResults() throws Exception {
        // Arrange
        EnergyReading solarReading = new EnergyReading();
        solarReading.setId(1L);
        solarReading.setDateTime(LocalDateTime.of(2024, 1, 1, 0, 0));
        solarReading.setSource(FuelType.SOLAR);
        solarReading.setMWh(55.0);

        Page<EnergyReading> filteredPage = new PageImpl<>(
                List.of(solarReading),
                PageRequest.of(0, 20),
                1
        );

        // Suppose you have a custom method: findBySource
        Mockito.when(repo.findBySource(eq(FuelType.SOLAR), any(Pageable.class)))
                .thenReturn(filteredPage);

        // Act & Assert
        mockMvc.perform(get("/energy-view").param("fuelType", "SOLAR"))
                .andExpect(status().isOk())
                .andExpect(content().string(org.hamcrest.Matchers.containsString("55.0")))
                .andExpect(content().string(org.hamcrest.Matchers.containsString("SOLAR")))
                .andExpect(view().name("energy"));
    }
}