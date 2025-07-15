package org.example.greenenergydatademo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EnergyController
{
    @GetMapping("/energy")
    public List<String> getEnergyData() {
        return List.of("Solar: 42kWh", "Wind: 25kWh", "Hydro: 10kWh");
    }
}
