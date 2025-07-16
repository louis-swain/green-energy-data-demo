package org.example.greenenergydatademo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EnergyController
{
    private final EnergyReadingRepository repo;

    public EnergyController(EnergyReadingRepository repo)
    {
        this.repo = repo;
    }

    @GetMapping("/energy")
    public List<EnergyReading> getAll() {
        return repo.findAll();
    }

    @PostMapping("/energy")
    public EnergyReading add(@RequestBody EnergyReading reading)
    {
        return repo.save(reading);
    }
}
