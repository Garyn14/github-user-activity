package com.roadmap.api.github.model.event;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.roadmap.api.github.model.GitHubAction;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class IssueCommentEvent extends GitHubAction {
    private Payload payload;

    @Override
    public String toString() {

        if (payload == null) return "Unknown action on " + this.getRepo().getName();

        return switch (payload.getAction()) {
            case "created" -> "Commented on " + this.getRepo().getName();
            case "edited" -> "Edited a comment on " + this.getRepo().getName();
            case "deleted" -> "Deleted a comment on " + this.getRepo().getName();
            default -> "Unknown action on " + this.getRepo().getName();
        };
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    @Getter @Setter
    private static class Payload {
        private String action;
    }
}
