package org.example.greenenergydatademo;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.mock.web.MockMultipartFile;

import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/**
 * Test service
 */
class ImportServiceTest {

    @Test
    void parsesAndSavesCsv() throws Exception {
        // Arrange
        String csvContent = "DATETIME,SOLAR\n" +
                "2024-01-01T00:00:00,123.4\n";

        MockMultipartFile file = new MockMultipartFile(
                "file", "test.csv", "text/csv", csvContent.getBytes(StandardCharsets.UTF_8)
        );

        EnergyReadingRepository fakeRepo = Mockito.mock(EnergyReadingRepository.class);

        when(fakeRepo.save(any(EnergyReading.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        ImportService service = new ImportService(fakeRepo);

        // Act
        int rows = service.importCsv(file.getInputStream());

        // Assert
        assertThat(rows).isEqualTo(1);
        Mockito.verify(fakeRepo, Mockito.times(1)).save(any(EnergyReading.class));
    }
}