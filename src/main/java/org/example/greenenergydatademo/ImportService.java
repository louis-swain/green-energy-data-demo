package org.example.greenenergydatademo;

import com.opencsv.CSVReader;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class ImportService
{

    private final EnergyReadingRepository repo;

    public ImportService(EnergyReadingRepository repo) {
        this.repo = repo;
    }

    public int importCsv(InputStream inputStream) throws Exception {
        System.out.println("Starting CSV import...");

        try (CSVReader reader = new CSVReader(new InputStreamReader(inputStream))) {
            List<String[]> rows = reader.readAll();

            String[] header = rows.get(0);
            DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;

            int imported = 0;

            for (int i = 1; i < rows.size(); i++) {
                String[] row = rows.get(i);

                LocalDateTime dateTime;
                try {
                    dateTime = LocalDateTime.parse(row[0], formatter);
                } catch (Exception e) {
                    System.out.println("Skipping row with invalid DATETIME: " + row[0]);
                    continue;
                }

                for (int j = 1; j < header.length; j++) {
                    String sourceStr = header[j].trim();

                    if (sourceStr.endsWith("_perc")
                            || sourceStr.equals("GENERATION")
                            || sourceStr.equals("CARBON_INTENSITY")
                            || sourceStr.equals("LOW_CARBON")
                            || sourceStr.equals("ZERO_CARBON")
                            || sourceStr.equals("RENEWABLE")
                            || sourceStr.equals("FOSSIL")) {
                        continue;
                    }

                    FuelType source;
                    try {
                        source = FuelType.valueOf(sourceStr);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Unknown fuel type: " + sourceStr);
                        continue;
                    }

                    String valueStr = row[j];
                    if (valueStr == null || valueStr.isBlank()) continue;

                    double mWh;
                    try {
                        mWh = Double.parseDouble(valueStr);
                    } catch (NumberFormatException e) {
                        System.out.println("Bad number for " + source + " at " + dateTime);
                        continue;
                    }

                    EnergyReading reading = new EnergyReading();
                    reading.setDateTime(dateTime);
                    reading.setSource(source);
                    reading.setMWh(mWh);

                    repo.save(reading);
                    imported++;
                }
            }

            System.out.println("CSV import finished. Rows inserted: " + imported);
            return imported;
        }
    }
}