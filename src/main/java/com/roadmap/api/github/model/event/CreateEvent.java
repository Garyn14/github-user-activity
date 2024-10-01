package com.roadmap.api.github.model.event;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.roadmap.api.github.model.GitHubAction;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateEvent extends GitHubAction {
    private Payload payload;

    @Override
    public String toString() {

        if (payload ==  null || payload.getRef_type() == null)
            return "unknown create event in " + (this.getRepo() != null ? this.getRepo().getName() : "unknown repository");

        return switch (payload.getRef_type()) {
            case "repository" -> "created repository " +  this.getRepo().getName();
            case "branch" -> "created branch " + payload.getRef() + " in " + this.getRepo().getName();
            case "tag" -> "created tag " + payload.getRef() + " in " + this.getRepo().getName();
            default -> "unknown create event in " + this.getRepo().getName();
        };

    }

    @Getter @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    private static class Payload {
        private String ref;
        private String ref_type;
    }
}
