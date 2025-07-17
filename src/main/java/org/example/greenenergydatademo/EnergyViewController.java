package org.example.greenenergydatademo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller //Use @Controller (not @RestController) for HTML views
public class EnergyViewController {

    private final EnergyReadingRepository repo;

    public EnergyViewController(EnergyReadingRepository repo) {
        this.repo = repo;
    }

    // EnergyViewController.java

    @GetMapping("/energy-view")
    public String viewEnergyData(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "100") int size,
            @RequestParam(required = false) FuelType fuelType,
            Model model
    ) {
        Page<EnergyReading> energyPage;

        Pageable pageable = PageRequest.of(page, size, Sort.by("dateTime").descending());

        if (fuelType != null) {
            energyPage = repo.findBySource(fuelType, pageable);
        } else {
            energyPage = repo.findAll(pageable);
        }

        int totalPages = energyPage.getTotalPages();
        int currentPage = page;

        // Calculate range to display
        int windowSize = 2; // number of pages either side of current
        int start = Math.max(1, currentPage + 1 - windowSize);
        int end = Math.min(totalPages, currentPage + 1 + windowSize);

        List<Integer> pageNumbers = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            pageNumbers.add(i);
        }

        model.addAttribute("energyPage", energyPage);
        model.addAttribute("currentPage", currentPage + 1);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("pageNumbers", pageNumbers);
        model.addAttribute("showFirst", start > 1);
        model.addAttribute("showLast", end < totalPages);
        model.addAttribute("fuelType", fuelType);
        model.addAttribute("fuelTypes", FuelType.values());

        return "energy";
    }
}