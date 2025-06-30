package org.example.buylist.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class AlertDTO {
    private String keyword;    // 품목
    private String title;      // 게시글 제목
    private String link;       // 링크
    private LocalDateTime detectedAt;
}