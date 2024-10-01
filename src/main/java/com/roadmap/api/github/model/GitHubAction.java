package com.roadmap.api.github.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.roadmap.api.github.model.event.*;
import lombok.Getter;
import lombok.Setter;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "type",
        defaultImpl = UnsupportedGitHubEvent.class
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = WatchEvent.class, name = "WatchEvent"),
        @JsonSubTypes.Type(value = IssueCommentEvent.class, name = "IssueCommentEvent"),
        @JsonSubTypes.Type(value = PushEvent.class, name = "PushEvent"),
        @JsonSubTypes.Type(value = PullRequestEvent.class, name = "PullRequestEvent"),
        @JsonSubTypes.Type(value = IssuesEvent.class, name = "IssuesEvent"),
        @JsonSubTypes.Type(value = CreateEvent.class, name = "CreateEvent")
})
@Getter @Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class GitHubAction {
    private Repository repo;

    @Override
    public String toString() {
        return "GitHubAction{" +
                "repo=" + repo +
                '}';
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    @Getter @Setter
    public static class Repository {
        private String name;

        @Override
        public String toString() {
            return "Repository{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}
