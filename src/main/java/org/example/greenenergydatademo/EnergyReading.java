package org.example.greenenergydatademo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class EnergyReading
{
    @Id
    private Long id;
    private String source;
    private Double kWh;
}
