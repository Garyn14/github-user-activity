package com.roadmap.api.github.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter @Setter
public class Payload {
    private String action;

    @Override
    public String toString() {
        return "Payload{" +
                "action='" + action + '\'' +
                '}';
    }
}
