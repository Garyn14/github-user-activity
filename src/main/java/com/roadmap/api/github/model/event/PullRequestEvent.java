package com.roadmap.api.github.model.event;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.roadmap.api.github.model.GitHubAction;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PullRequestEvent extends GitHubAction {
    private Payload payload;

    @Override
    public String toString() {

        if (payload == null || payload.getAction() == null)
            return "Unknown action on " + this.getRepo().getName();

        return switch (payload.getAction()) {
            case "opened" -> "Opened a pull request on " + this.getRepo().getName();
            case "edited" -> "Edited a pull request on " + this.getRepo().getName();
            case "closed" -> "Closed a pull request on " + this.getRepo().getName();
            case "reopened" -> "Reopened a pull request on " + this.getRepo().getName();
            case "assigned" -> "Assigned a pull request on " + this.getRepo().getName();
            case "unassigned" -> "Unassigned a pull request on " + this.getRepo().getName();
            case "review_requested" -> "Review requested on a pull request on " + this.getRepo().getName();
            case "review_request_removed" -> "Review request removed on a pull request on " + this.getRepo().getName();
            case "labeled" -> "Labeled a pull request on " + this.getRepo().getName();
            case "unlabeled" -> "Unlabeled a pull request on " + this.getRepo().getName();
            case "synchronized" -> "Synchronized a pull request on " + this.getRepo().getName();
            default -> "Unknown action on " + this.getRepo().getName();
        };
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    @Getter @Setter
    private static class Payload {
        private String action;
    }
}
