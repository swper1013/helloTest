package org.example.buylist.util;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.example.buylist.dto.ListDto;
import org.example.buylist.service.ListService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
@Log4j2
public class KeywordMonitorScheduler {
    private final ListService listService;
    private  PpomppuCrawler ppomppuCrawler= new PpomppuCrawler();

    @Scheduled(fixedRate = 3000)
    public void checkForMatches() {
        log.info("⏰ 크롤링 시작 - {}", LocalDateTime.now());
        List<ListDto> items = listService.findAll();
        for(ListDto listDto : items) {
            List<String> matches = ppomppuCrawler.findTitlesByKeyword(listDto.getValueName());
            if(!matches.isEmpty()) {
                String message = "[핫딜 찾음!]"+listDto.getValueName() + "관련 게시글발견!\n" + matches.get(0);
                System.out.println("알림!:"+message);
                log.info("🔔 알림 발생: {}", message);
            }
        }
        log.info("✅ 크롤링 완료");
    }
}
