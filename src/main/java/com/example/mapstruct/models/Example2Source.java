package com.example.mapstruct.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@Builder
public class Example2Source {

    private List<Integer> myIntegers;
    private List<String> myStrings;

}
