package org.example.buylist.Mapper;

import org.example.buylist.dto.ListDto;
import org.example.buylist.entity.BuylistEntity;
import org.mapstruct.*;


import java.time.format.DateTimeFormatter;

@Mapper(componentModel = "spring")
public interface BuylistMapper {

    @Mapping(target = "createdAt", expression = "java(formatDate(entity.getCreatedAt()))")
    ListDto toDTO(BuylistEntity entity);

    @Mapping(target = "createdAt", ignore = true) // 생성 시점은 서버에서 지정
    BuylistEntity toEntity(ListDto dto);

    default String formatDate(java.time.LocalDateTime time) {
        if (time == null) return null;
        return time.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    }
}
