package org.example.greenenergydatademo;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.mock.web.MockMultipartFile;

import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test service
 */
class ImporterServiceTest {

    @Test
    void parsesAndSavesCsv() throws Exception {
        // Arrange
        String csvContent = "DATETIME,SOURCE,MWH\n" +
                "2024-01-01T00:00:00,SOLAR,123.4\n";

        MockMultipartFile file = new MockMultipartFile(
                "file", "test.csv", "text/csv", csvContent.getBytes(StandardCharsets.UTF_8)
        );

        EnergyReadingRepository fakeRepo = Mockito.mock(EnergyReadingRepository.class);

        ImportService service = new ImportService(fakeRepo);

        // Act
        int rows = service.importCsv(file);

        // Assert
        assertThat(rows).isEqualTo(1);
        Mockito.verify(fakeRepo, Mockito.times(1)).save(Mockito.any(EnergyReading.class));
    }
}