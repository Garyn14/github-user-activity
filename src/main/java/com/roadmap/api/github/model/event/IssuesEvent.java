package com.roadmap.api.github.model.event;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.roadmap.api.github.model.GitHubAction;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter @Setter
public class IssuesEvent extends GitHubAction {
    private Payload payload;

    @Override
    public String toString() {

        if (payload == null || payload.getAction() == null)
            return "Unknown action on " + this.getRepo().getName();

        return switch (payload.getAction()) {
            case "opened" -> "Opened an issue on " + this.getRepo().getName();
            case "edited" -> "Edited an issue on " + this.getRepo().getName();
            case "closed" -> "Closed an issue on " + this.getRepo().getName();
            case "reopened" -> "Reopened an issue on " + this.getRepo().getName();
            case "assigned" -> "Assigned an issue on " + this.getRepo().getName();
            case "unassigned" -> "Unassigned an issue on " + this.getRepo().getName();
            case "labeled" -> "Labeled an issue on " + this.getRepo().getName();
            case "unlabeled" -> "Unlabeled an issue on " + this.getRepo().getName();
            default -> "Unknown action on " + this.getRepo().getName();
        };

    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    @Getter @Setter
    private static class Payload {
        private String action;
    }
}
