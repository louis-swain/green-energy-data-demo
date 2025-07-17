package org.example.greenenergydatademo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller //Use @Controller (not @RestController) for HTML views
public class EnergyViewController {

    private final EnergyReadingRepository repo;

    public EnergyViewController(EnergyReadingRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/energy-view")
    public String viewEnergy(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "1000") int size,
            Model model) {

        Pageable pageable = PageRequest.of(page, size);
        Page<EnergyReading> pageResult = repo.findAll(pageable);

        model.addAttribute("page", pageResult);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", pageResult.getTotalPages());

        return "energy";
    }
}