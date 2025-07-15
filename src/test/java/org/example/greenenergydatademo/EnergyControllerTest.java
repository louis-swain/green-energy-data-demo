package org.example.greenenergydatademo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class EnergyControllerTest
{
    @Autowired
    private EnergyController energyController;

    @Test
    void testEnergyEndpoint() {
        assertNotNull(energyController.getEnergyData());
    }
}
