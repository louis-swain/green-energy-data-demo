package org.example.greenenergydatademo;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Test HTML view
 */
@WebMvcTest(EnergyViewController.class)
class EnergyViewControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EnergyReadingRepository repo;

    @Test
    void energyViewReturnsHtml() throws Exception {
        when(repo.findAll(Mockito.any(Pageable.class)))
                .thenReturn(new PageImpl<>(Collections.emptyList()));

        mockMvc.perform(get("/energy-view"))
                .andExpect(status().isOk())
                .andExpect(view().name("energy"))
                .andExpect(model().attributeExists("page"));
    }
}