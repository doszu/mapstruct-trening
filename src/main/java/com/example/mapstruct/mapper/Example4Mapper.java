package com.example.mapstruct.mapper;

import com.example.mapstruct.models.Example1Source;
import com.example.mapstruct.models.Example1Target;
import com.example.mapstruct.models.Example1Enum;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ValueMapping;
import org.mapstruct.factory.Mappers;

//from version 1.4.0.Beta1
@Mapper
public interface Example4Mapper {

    @ValueMapping(source = "BLUE", target = "B")
    @ValueMapping(source = "YELLOW", target = "Y")
    @ValueMapping(source = "RED", target = "R")
    String example1EnumToString(Example1Enum type);

    Example4Mapper INSTANCE = Mappers.getMapper( Example4Mapper.class);

    @Mapping(source = "count", target = "counter" )
    Example1Target toExampleDtoCustom(Example1Source example1Source);
}
