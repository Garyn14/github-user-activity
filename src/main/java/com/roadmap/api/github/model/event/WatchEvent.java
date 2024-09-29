package com.roadmap.api.github.model.event;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.roadmap.api.github.model.GitHubAction;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class WatchEvent extends GitHubAction {

    private Payload payload;

    @Override
    public String toString() {
        return super.toString()  + "WatchEvent{"+
                "payload=" + payload +
                '}';
    }

    @Getter @Setter
    private static class Payload {
        private String action;

        @Override
        public String toString() {
            return "Payload{" +
                    "action='" + action + '\'' +
                    '}';
        }
    }
}
