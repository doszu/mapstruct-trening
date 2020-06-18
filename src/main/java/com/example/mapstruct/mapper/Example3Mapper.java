package com.example.mapstruct.mapper;

import com.example.mapstruct.models.Example3Source;
import com.example.mapstruct.models.Example3Target;
import com.example.mapstruct.utils.MappingUtilMap;
import com.example.mapstruct.utils.MappingUtilMap.Ip;
import com.example.mapstruct.utils.MappingUtilMap.Server;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper( uses = MappingUtilMap.class)
public interface Example3Mapper {

    Example3Mapper MAPPER = Mappers.getMapper( Example3Mapper.class );

    @Mapping(source = "map", target = "ip", qualifiedBy = Ip.class )
    @Mapping(source = "map", target = "server", qualifiedBy = Server.class )
    Example3Target toTarget(Example3Source s);
}
