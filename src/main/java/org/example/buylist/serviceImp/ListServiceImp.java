package org.example.buylist.serviceImp;

import lombok.RequiredArgsConstructor;
import org.example.buylist.Mapper.BuylistMapper;
import org.example.buylist.dto.ListDto;
import org.example.buylist.entity.BuylistEntity;
import org.example.buylist.repository.ListRepository;
import org.example.buylist.service.ListService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ListServiceImp implements ListService {
    private final ListRepository listRepository;
    private final BuylistMapper  mapper;

    @Override
    public void save(ListDto listDto) {
        BuylistEntity buylistEntity =mapper.toEntity(listDto);
        buylistEntity.setCreatedAt(LocalDateTime.now());
        listRepository.save(buylistEntity);
    }

    @Override
    public List<ListDto> findAll() {

        return listRepository.findAll(Sort.by(Sort.Direction.DESC,"createdAt")).stream()
                .map(mapper::toDTO)
                .toList();
    }

    @Override
    public void delete(Long id) {
        listRepository.deleteById(id);
    }
}
