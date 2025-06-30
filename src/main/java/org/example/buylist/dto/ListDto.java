package org.example.buylist.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ListDto {
    private long id;

    private String valueName;

    private String site;

    private Integer lowPrice;

    private Integer wantPrice;

    private String createdAt;
}
