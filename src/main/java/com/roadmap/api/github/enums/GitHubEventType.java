package com.roadmap.api.github.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum GitHubEventType {
    WATCH_EVENT("WatchEvent");
    /*
    PULL_REQUEST_EVENT("PullRequestEvent"),
    ISSUES_EVENT("IssuesEvent"),
    FORK_EVENT("ForkEvent"),
    PUSH_EVENT("PushEvent"),
    COMMIT_COMMENT_EVENT("CommitCommentEvent"),
    CREATE_EVENT("CreateEvent"),
    DELETE_EVENT("DeleteEvent"),
    RELEASE_EVENT("ReleaseEvent"),
    GOLLUM_EVENT("GollumEvent"),
    ISSUE_COMMENT_EVENT("IssueCommentEvent"),
    MEMBER_EVENT("MemberEvent"),
    PUBLIC_EVENT("PublicEvent"),
    PULL_REQUEST_REVIEW_EVENT("PullRequestReviewEvent"),
    PULL_REQUEST_REVIEW_COMMENT_EVENT("PullRequestReviewCommentEvent"),
    PULL_REQUEST_REVIEW_THREAD_EVENT("PullRequestReviewThreadEvent"),
    STATUS_EVENT("StatusEvent"),
    TEAM_ADD_EVENT("TeamAddEvent");
    */

    private final String eventType;

    GitHubEventType(String eventType) {
        this.eventType = eventType;
    }

    @JsonValue
    public String getEventType() {
        return eventType;
    }

    @JsonCreator
    public static GitHubEventType fromString(String eventType) {
        for (GitHubEventType type : GitHubEventType.values()) {
            if (type.eventType.equalsIgnoreCase(eventType)) {
                return type;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return eventType;
    }
}
