package org.example.buylist.repository;

import org.example.buylist.entity.CrawlResultEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CrawlResultRepository extends JpaRepository<CrawlResultEntity, Long> {
}
