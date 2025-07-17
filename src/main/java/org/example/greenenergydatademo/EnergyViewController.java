package org.example.greenenergydatademo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller //Use @Controller (not @RestController) for HTML views
public class EnergyViewController {

    private final EnergyReadingRepository repo;

    public EnergyViewController(EnergyReadingRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/energy-view")
    public String viewEnergy(Model model) {
        model.addAttribute("readings", repo.findAll());
        return "energy"; // Thymeleaf will render energy.html
    }
}