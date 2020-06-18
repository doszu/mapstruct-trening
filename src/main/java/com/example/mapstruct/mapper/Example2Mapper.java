package com.example.mapstruct.mapper;

import com.example.mapstruct.models.Example2Source;
import com.example.mapstruct.models.Example2Target;
import com.example.mapstruct.utils.MappingUtilList;
import com.example.mapstruct.utils.MappingUtilList.FirstElement;
import com.example.mapstruct.utils.MappingUtilList.LastElement;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper( uses = MappingUtilList.class)
public interface Example2Mapper {

    Example2Mapper MAPPER = Mappers.getMapper( Example2Mapper.class );

    @Mapping( source = "myIntegers", target = "myInteger", qualifiedBy = FirstElement.class )
    @Mapping( source = "myStrings", target = "myString", qualifiedBy = LastElement.class )
    Example2Target toTarget(Example2Source s );
}
