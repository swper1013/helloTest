package org.example.buylist.Mapper;

import org.example.buylist.dto.ListDto;
import org.example.buylist.entity.BuylistEntity;
import org.mapstruct.*;

import java.time.format.DateTimeFormatter;

// 🔥 여기서 @Mapper(componentModel = "spring") 삭제
public interface BuylistMapper {

    @Mapping(target = "createdAt", expression = "java(formatDate(entity.getCreatedAt()))")
    ListDto toDTO(BuylistEntity entity);

    @Mapping(target = "createdAt", ignore = true)
    BuylistEntity toEntity(ListDto dto);

    default String formatDate(java.time.LocalDateTime time) {
        if (time == null) return null;
        return time.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    }
}
