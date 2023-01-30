package sample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;

@RestController
public class SampleController {
    @GetMapping("/api/v1/sample/{name}/{description}")
    public SampleDto sample(@PathVariable String name, @PathVariable String description){
        return SampleDto.builder()
                .description(description)
                .name(name)
                .number(10L)
                .now(ZonedDateTime.now())
                .build();
    }
}
