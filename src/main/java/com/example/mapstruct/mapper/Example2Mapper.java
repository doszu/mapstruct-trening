package com.example.mapstruct.mapper;

import com.example.mapstruct.models.Example1;
import com.example.mapstruct.models.Example1Dto;
import com.example.mapstruct.models.Example1Enum;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ValueMapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface Example2Mapper {

    @ValueMapping(source = "BLUE", target = "B")
    @ValueMapping(source = "YELLOW", target = "Y")
    @ValueMapping(source = "RED", target = "R")
    String example1EnumToString(Example1Enum type);

    Example2Mapper INSTANCE = Mappers.getMapper( Example2Mapper.class);

    @Mapping(source = "count", target = "counter" )
    Example1Dto toExampleDtoCustom(Example1 example1);
}
