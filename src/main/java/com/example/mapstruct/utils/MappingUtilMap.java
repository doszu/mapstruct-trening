package com.example.mapstruct.utils;

import org.mapstruct.Qualifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Map;

public class MappingUtilMap {

    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.CLASS)
    public @interface Ip {
    }

    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.CLASS)
    public static @interface Server {
    }

    @Ip
    public String ip(Map<String, Object> in) {
        return (String) in.get("ip");
    }

    @Server
    public String server(Map<String, Object> in) {
        return (String) in.get("server");
    }


}
