package sample.controller;

import lombok.Builder;
import lombok.Getter;

import java.time.ZonedDateTime;

@Getter
public class SampleDto {
    private final String name;
    private final String description;
    private final Long number;
    private final ZonedDateTime now;

    @Builder
    public  SampleDto(String name, String description, Long number, ZonedDateTime now){
        this.name=name;
        this.description=description;
        this.number=number;
        this.now=now;

    }

}
