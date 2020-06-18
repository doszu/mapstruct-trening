package com.example.mapstruct.mapper;

import com.example.mapstruct.models.Example6;
import org.mapstruct.Mapper;
import org.mapstruct.control.DeepClone;
import org.mapstruct.factory.Mappers;

//from version 1.4.0.Beta1
@Mapper(mappingControl = DeepClone.class)
public interface Example6Mapper {

    Example6Mapper INSTANCE = Mappers.getMapper( Example6Mapper.class);

    Example6 copyExample6Dto(Example6 example);
}
