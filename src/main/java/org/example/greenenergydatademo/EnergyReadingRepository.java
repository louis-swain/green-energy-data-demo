package org.example.greenenergydatademo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EnergyReadingRepository extends JpaRepository<EnergyReading, Long>
{
}
