package com.example.mapstruct.mapper;

import com.example.mapstruct.models.Example3;
import org.mapstruct.Mapper;
import org.mapstruct.control.DeepClone;
import org.mapstruct.factory.Mappers;

@Mapper(mappingControl = DeepClone.class)
public interface Example3Mapper {

    Example3Mapper INSTANCE = Mappers.getMapper( Example3Mapper.class);

    Example3 copyExample2Dto(Example3 example);
}
