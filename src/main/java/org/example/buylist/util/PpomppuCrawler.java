package org.example.buylist.util;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.example.buylist.entity.BuylistEntity;
import org.example.buylist.entity.CrawlResultEntity;

import org.example.buylist.repository.CrawlResultRepository;
import org.example.buylist.repository.ListRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Log4j2
@Component
@RequiredArgsConstructor
public class PpomppuCrawler {

    private final ListRepository buylistRepository; // ✅ 등록 품목 조회용
    private final CrawlResultRepository crawlResultRepository; // ✅ 결과 저장용

    public void crawlAndSaveAll() {
        log.info("🔎 즉시 크롤링 시작 (전체 품목)");

        try {
            // ✅ DB에서 모든 품목 조회
            List<BuylistEntity> buylist = buylistRepository.findAll();

            // ✅ 뽐뿌 페이지 크롤링
            Document doc = Jsoup.connect("https://www.ppomppu.co.kr/zboard/zboard.php?id=ppomppu").get();
            Elements rows = doc.select("tr.baseList");

            for (Element row : rows) {
                Element titleElement = row.selectFirst("a.baseList-title");
                if (titleElement != null) {
                    String title = titleElement.text();
                    String link = "https://www.ppomppu.co.kr/zboard/" + titleElement.attr("href");

                    log.info("📄 파싱된 제목: {}", title);

                    for (BuylistEntity item : buylist) {
                        if (title.contains(item.getValueName())) {
                            // 💡 가격 숫자 추출 (단순 예시)
                            int price = extractPrice(title);
                            if (price <= item.getWantPrice()) {
                                // ✅ DB에 저장
                                CrawlResultEntity result = CrawlResultEntity.builder()
                                        .keyword(item.getValueName())
                                        .title(title)
                                        .link(link)
                                        .detectedAt(LocalDateTime.now())
                                        .build();
                                crawlResultRepository.save(result);
                                log.info("✅ 저장 완료: {}", result);
                            }
                        }
                    }
                }
            }

        } catch (Exception e) {
            log.error("❌ 크롤링 중 오류 발생", e);
        }

        log.info("✅ 즉시 크롤링 완료");
    }

    /**
     * 🔧 제목에서 숫자(가격)를 추출하는 간단한 예시 메서드
     */
    private int extractPrice(String title) {
        try {
            // 예: "아이패드 (123,456원/무료)" -> 123456 추출
            String digits = title.replaceAll("[^0-9]", "");
            return Integer.parseInt(digits);
        } catch (Exception e) {
            return Integer.MAX_VALUE; // 가격 없으면 매우 큰 값
        }
    }
}
