package com.example.mapstruct.mapper;

import com.example.mapstruct.models.Example1;
import com.example.mapstruct.models.Example1Dto;
import com.example.mapstruct.models.Example1Enum;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper
public interface Example1Mapper {

    Example1Mapper INSTANCE = Mappers.getMapper( Example1Mapper.class);

    @Mapping(source = "count", target = "counter")
    Example1Dto toExampleDto(Example1 example1);

    @InheritInverseConfiguration( name = "toExampleDto")
    Example1 toExampleEntity(Example1Dto example1Dto);




}
