package com.example.mapstruct.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@Builder
@ToString
public class Example3Target {
    private String ip;
    private String server;

}
