package com.example.mapstruct.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Example5Source {

    private String title;
    private Example5_1Source props;

}
