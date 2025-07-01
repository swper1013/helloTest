package org.example.buylist.service;

import org.example.buylist.entity.CrawlResultEntity;

import java.util.List;

public interface CrawlResultService {
    List<CrawlResultEntity> findAll();
}
