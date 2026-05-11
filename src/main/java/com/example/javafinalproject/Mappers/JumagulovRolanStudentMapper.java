package com.example.javafinalproject.Mappers;

import com.example.javafinalproject.DTOs.JumagulovRolanStudentDTO;
import com.example.javafinalproject.Entities.JumagulovRolanStudent;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface JumagulovRolanStudentMapper {
    JumagulovRolanStudentDTO toDto (JumagulovRolanStudent jumagulovRolanStudent);

    @Mapping(target = "id", ignore = true )
    JumagulovRolanStudent toEntity (JumagulovRolanStudentDTO dto);

}
