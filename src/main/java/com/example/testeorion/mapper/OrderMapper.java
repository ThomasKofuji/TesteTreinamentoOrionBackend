package com.example.testeorion.mapper;

import com.example.testeorion.dto.OrderDto;
import com.example.testeorion.model.Orders;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrderMapper{
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);
    Orders toEntity(OrderDto orderDto);
    OrderDto toDto(Orders order);
}