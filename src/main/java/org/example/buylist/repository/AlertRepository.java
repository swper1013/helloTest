package org.example.buylist.repository;

import org.example.buylist.entity.AlertEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlertRepository extends JpaRepository<AlertEntity, Long> {
    List<AlertEntity> findByKeywordContaining(String keyword);
}