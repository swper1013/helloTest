package org.example.buylist.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "alert")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AlertEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String keyword;

    private String title;

    private String link;

    private LocalDateTime detectedAt;
}
