package com.example.mapstruct.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Example1Target {
    private String title;
    private long counter;
    private String type;
    private String propField;
}
