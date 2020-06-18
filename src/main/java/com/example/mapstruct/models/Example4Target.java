package com.example.mapstruct.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@Builder
@ToString
public class Example4Target {
    private String ip;
    private String server;

}
