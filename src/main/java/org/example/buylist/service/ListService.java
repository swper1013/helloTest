package org.example.buylist.service;

import org.example.buylist.dto.ListDto;

import java.util.List;

public interface ListService {
    void save(ListDto listDto);
    List<ListDto> findAll();
    void delete(Long id);
}
