package com.example.testeorion.mapper;

import com.example.testeorion.dto.UserDto;
import com.example.testeorion.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper{
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    User toEntity(UserDto userDto);
    UserDto toDto(User user);
}