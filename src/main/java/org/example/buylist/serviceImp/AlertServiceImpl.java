package org.example.buylist.serviceImp;

import lombok.RequiredArgsConstructor;
import org.example.buylist.Mapper.AlertMapper;
import org.example.buylist.dto.AlertDTO;
import org.example.buylist.repository.AlertRepository;
import org.example.buylist.service.AlertService;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlertServiceImpl implements AlertService {

    private final AlertRepository alertRepository;
    private final SimpMessagingTemplate messagingTemplate;
    private final AlertMapper alertMapper;

    @Override
    public void saveAndSend(AlertDTO dto) {
        // 1. 저장
        alertRepository.save(alertMapper.toEntity(dto));

        // 2. STOMP 전송
        messagingTemplate.convertAndSend("/topic/alerts", dto);
    }

    @Override
    public List<AlertDTO> getAlerts(String keyword) {
        return alertRepository.findByKeywordContaining(keyword)
                .stream()
                .map(alertMapper::toDto)
                .toList();
    }
}