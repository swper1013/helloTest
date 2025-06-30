package org.example.buylist.service;

import org.example.buylist.dto.AlertDTO;

import java.util.List;

public interface AlertService {
    void saveAndSend(AlertDTO dto);
    List<AlertDTO> getAlerts(String keyword);
}