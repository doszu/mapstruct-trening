package com.example.mapstruct.mapper;

import com.example.mapstruct.models.Example5Source;
import com.example.mapstruct.models.Example5Target;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface Example5Mapper {

    Example5Mapper INSTANCE = Mappers.getMapper(Example5Mapper.class);

    //from version 1.4.0.Beta1
    @Mapping(source = "props", target = ".")
    Example5Target toTarget(Example5Source source);


    // 1.3.1
    @Mapping(source = ".", target = "props")
    Example5Source toSource(Example5Target target);

}
