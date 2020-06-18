package com.example.mapstruct.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@Builder

public class Example6 {
    private String title;
    private Example6_1 example6_1;
    private List<Example6_2> example6_2List;
}
