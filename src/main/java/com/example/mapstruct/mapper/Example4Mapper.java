package com.example.mapstruct.mapper;

import com.example.mapstruct.models.Example4Source;
import com.example.mapstruct.models.Example4Target;
import com.example.mapstruct.utils.MappingUtilMap;
import com.example.mapstruct.utils.MappingUtilMap.Ip;
import com.example.mapstruct.utils.MappingUtilMap.Server;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper( uses = MappingUtilMap.class)
public interface Example4Mapper {

    Example4Mapper MAPPER = Mappers.getMapper( Example4Mapper.class );

    @Mapping(source = "map", target = "ip", qualifiedBy = Ip.class )
    @Mapping(source = "map", target = "server", qualifiedBy = Server.class )
    Example4Target toTarget(Example4Source s);
}
