package com.example.mapstruct.mapper;

import com.example.mapstruct.models.Example1Source;
import com.example.mapstruct.models.Example1Target;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper
public interface Example1Mapper {

    Example1Mapper INSTANCE = Mappers.getMapper( Example1Mapper.class);

    @Mapping(source = "count", target = "counter")
    @Mapping(source = "propObj.prop", target = "propField")
    Example1Target toExampleDto(Example1Source example1Source);

    @InheritInverseConfiguration( name = "toExampleDto")
    Example1Source toExampleEntity(Example1Target example1Target);




}
