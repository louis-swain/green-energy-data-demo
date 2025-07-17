package org.example.greenenergydatademo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test repository
 */
@DataJpaTest
class EnergyReadingRepositoryTest {

    @Autowired
    private EnergyReadingRepository repo;

    @Test
    void savesAndFinds() {
        EnergyReading reading = new EnergyReading();
        reading.setDateTime(LocalDateTime.now());
        reading.setSource(FuelType.WIND);
        reading.setMWh(200.0);

        EnergyReading saved = repo.save(reading);

        assertThat(saved.getId()).isNotNull();
        assertThat(repo.findById(saved.getId())).isPresent();
    }
}