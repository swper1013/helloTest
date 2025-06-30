package org.example.buylist.Mapper;

import org.example.buylist.dto.AlertDTO;
import org.example.buylist.entity.AlertEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AlertMapper {
    AlertEntity toEntity(AlertDTO dto);
    AlertDTO toDto(AlertEntity entity);
}
