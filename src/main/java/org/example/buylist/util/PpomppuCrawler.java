package org.example.buylist.util;
import lombok.extern.log4j.Log4j2;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

@Log4j2
public class PpomppuCrawler {

    public List<String> findTitlesByKeyword(String keyword) {
        List<String> result = new ArrayList<>();
        try {
            Document doc = Jsoup.connect("https://www.ppomppu.co.kr/zboard/zboard.php?id=ppomppu").get();
            Elements rows = doc.select("tr.list0, tr.list1");

            for (Element row : rows) {
                Element title = row.selectFirst(".list_title");
                if (title != null && title.text().toLowerCase().contains(keyword.toLowerCase())) {
                    result.add(title.text());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info(result);
        return result;
    }
}