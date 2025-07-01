package org.example.buylist.serviceImp;

import lombok.RequiredArgsConstructor;
import org.example.buylist.entity.CrawlResultEntity;
import org.example.buylist.repository.CrawlResultRepository;
import org.example.buylist.service.CrawlResultService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CrawlResultServiceImpl implements CrawlResultService {

    private final CrawlResultRepository crawlResultRepository;

    @Override
    public List<CrawlResultEntity> findAll() {
        return crawlResultRepository.findAll();
    }
}
