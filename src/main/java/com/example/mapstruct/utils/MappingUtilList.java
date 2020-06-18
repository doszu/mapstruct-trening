package com.example.mapstruct.utils;

import org.mapstruct.Qualifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;

public class MappingUtilList {

    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.CLASS)
    public @interface FirstElement {
    }

    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.CLASS)
    public @interface LastElement {
    }

    @FirstElement
    public <T> T first( List<T> in ) {
        if ( in != null && !in.isEmpty() ) {
            return in.get( 0 );
        }
        else {
            return null;
        }
    }

    @LastElement
    public <T> T last( List<T> in ) {
        if ( in != null && !in.isEmpty() ) {
            return in.get( in.size() - 1 );
        }
        else {
            return null;
        }
    }

}
