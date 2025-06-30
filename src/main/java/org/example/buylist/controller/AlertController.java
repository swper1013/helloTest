package org.example.buylist.controller;

import lombok.RequiredArgsConstructor;
import org.example.buylist.service.AlertService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class AlertController
{
    private final AlertService alertService;

    @GetMapping("/alerts")
    public String getAlerts(@RequestParam(required = false) String keyword, Model model) {
        model.addAttribute("alerts", alertService.getAlerts(keyword == null ? "" : keyword));
        return "pages/page3";
    }
}
