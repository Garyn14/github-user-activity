package com.roadmap.api.github.model.event;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.roadmap.api.github.model.GitHubAction;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PushEvent extends GitHubAction{
    private Payload payload;

    @Override
    public String toString() {

        if (payload == null || payload.getSize() == null)
            return "Unknown action on " + this.getRepo().getName();

        if (payload.getSize() == 1) return "Pushed 1 commit to " + this.getRepo().getName();

        return "Pushed " + this.getPayload().getSize() + " commits to " + this.getRepo().getName();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    @Getter @Setter
    private static class Payload {
        private Integer size;
    }
}
