package org.example.buylist.controller;

import lombok.RequiredArgsConstructor;
import org.example.buylist.service.AlertService;
import org.example.buylist.util.PpomppuCrawler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class AlertController {

    private final AlertService alertService;
    private final PpomppuCrawler ppomppuCrawler;

    @GetMapping("/alerts")
    public String getAlerts(@RequestParam(required = false) String keyword, Model model) {
        model.addAttribute("alerts", alertService.getAlerts(keyword == null ? "" : keyword));
        return "pages/page3";
    }


}
