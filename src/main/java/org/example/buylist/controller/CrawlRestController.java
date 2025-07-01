package org.example.buylist.controller;

import lombok.RequiredArgsConstructor;
import org.example.buylist.service.ListService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CrawlRestController {

    private final ListService listService;

    @GetMapping("/crawlNow")
    public String crawlNow(@RequestParam String keyword) {
        listService.crawlNow(keyword);
        return "✅ 크롤링 완료! DB에 저장되었습니다.";
    }
}
