package com.hemlata.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.hemlata.app.models.LocationStats;
import com.hemlata.app.service.CoronaDataService;

import java.util.List;

@Controller
public class HomeController {

   @Autowired
    CoronaDataService coronaDataService;

    @GetMapping("/")
    public String home(Model model) {
        List<LocationStats> allStats = coronaDataService.getAllStats();
        int totalconfirmedCases = allStats.stream().mapToInt(stat -> stat.cc).sum();
        int totalRecoveredCases = allStats.stream().mapToInt(stat -> stat.rc).sum();
        int totalDeathCases= allStats.stream().mapToInt(stat -> stat.dc).sum();
        int totalActiveCases= allStats.stream().mapToInt(stat -> stat.ac).sum();
        model.addAttribute("locationStats", allStats);
        model.addAttribute("totalconfirmedCases", totalconfirmedCases);
        model.addAttribute("totalRecoveredCases", totalRecoveredCases);
        model.addAttribute("totalDeathCases", totalDeathCases);
        model.addAttribute("totalActiveCases", totalActiveCases);
        

        return "home";
    }
}
