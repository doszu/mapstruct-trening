package com.example.mapstruct.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Example1Source {
    private String title;
    private long count;
    private Example1Enum type;
    private Example1_1Source propObj;
}
