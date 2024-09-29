package com.roadmap.api.github.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter @Setter
public class Repository {
    private String name;

    @Override
    public String toString() {
        return "Repository{" +
                "name='" + name + '\'' +
                '}';
    }
}
