package com.example.mapstruct.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@Builder

public class Example3 {
    private String title;
    private Example3_1 example3_1;
    private List<Example3_2> example3_2List;
}
