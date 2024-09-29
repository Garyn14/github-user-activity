package com.roadmap.api.github.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.roadmap.api.github.enums.GitHubEventType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter @Setter
@EqualsAndHashCode
public class Activity {

    private GitHubEventType type;
    private Repository repo;
    private Payload payload;

    @Override
    public String toString() {
        return "Activity{" +
                "type='" + type + '\'' +
                ", repo=" + repo +
                ", payload=" + payload +
                '}';
    }
}
