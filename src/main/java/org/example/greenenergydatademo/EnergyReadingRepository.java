package org.example.greenenergydatademo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnergyReadingRepository extends JpaRepository<EnergyReading, Long>
{
    Page<EnergyReading> findBySource(FuelType fuelType, Pageable pageable);
}
